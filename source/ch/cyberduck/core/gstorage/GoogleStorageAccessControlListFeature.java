package ch.cyberduck.core.gstorage;

/*
 * Copyright (c) 2002-2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.Acl;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.i18n.Locale;
import ch.cyberduck.core.s3.S3AccessControlListFeature;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jets3t.service.ServiceException;
import org.jets3t.service.acl.AccessControlList;
import org.jets3t.service.acl.Permission;
import org.jets3t.service.acl.gs.AllAuthenticatedUsersGrantee;
import org.jets3t.service.acl.gs.AllUsersGrantee;
import org.jets3t.service.acl.gs.GSAccessControlList;
import org.jets3t.service.acl.gs.GroupByDomainGrantee;
import org.jets3t.service.acl.gs.GroupByEmailAddressGrantee;
import org.jets3t.service.acl.gs.GroupByIdGrantee;
import org.jets3t.service.acl.gs.UserByEmailAddressGrantee;
import org.jets3t.service.acl.gs.UserByIdGrantee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version $Id$
 */
public class GoogleStorageAccessControlListFeature extends S3AccessControlListFeature {
    private static final Logger log = Logger.getLogger(GoogleStorageAccessControlListFeature.class);

    public GoogleStorageAccessControlListFeature(final GoogleStorageSession session) {
        super(session);
    }

    @Override
    protected AccessControlList convert(final Acl acl) {
        GSAccessControlList list = new GSAccessControlList();
        // Do not set owner for ACL which is set automatically
        for(Acl.UserAndRole userAndRole : acl.asList()) {
            if(!userAndRole.isValid()) {
                continue;
            }
            if(userAndRole.getUser() instanceof Acl.EmailUser) {
                list.grantPermission(new UserByEmailAddressGrantee(userAndRole.getUser().getIdentifier()),
                        Permission.parsePermission(userAndRole.getRole().getName()));
            }
            else if(userAndRole.getUser() instanceof Acl.GroupUser) {
                if(userAndRole.getUser().getIdentifier().equals(new AllUsersGrantee().getIdentifier())
                        || userAndRole.getUser().getIdentifier().equals(Acl.GroupUser.EVERYONE)) {
                    list.grantPermission(new AllUsersGrantee(),
                            Permission.parsePermission(userAndRole.getRole().getName()));
                }
                else if(userAndRole.getUser().getIdentifier().equals(new AllAuthenticatedUsersGrantee().getIdentifier())
                        || userAndRole.getUser().getIdentifier().equals(Acl.GroupUser.AUTHENTICATED)) {
                    list.grantPermission(new AllAuthenticatedUsersGrantee(),
                            Permission.parsePermission(userAndRole.getRole().getName()));
                }
                else {
                    list.grantPermission(new GroupByIdGrantee(userAndRole.getUser().getIdentifier()),
                            Permission.parsePermission(userAndRole.getRole().getName()));
                }
            }
            else if(userAndRole.getUser() instanceof Acl.DomainUser) {
                list.grantPermission(new GroupByDomainGrantee(userAndRole.getUser().getIdentifier()),
                        Permission.parsePermission(userAndRole.getRole().getName()));
            }
            else if(userAndRole.getUser() instanceof Acl.CanonicalUser) {
                list.grantPermission(new UserByIdGrantee(userAndRole.getUser().getIdentifier()),
                        Permission.parsePermission(userAndRole.getRole().getName()));
            }
            else if(userAndRole.getUser() instanceof Acl.EmailGroupUser) {
                list.grantPermission(new GroupByEmailAddressGrantee(userAndRole.getUser().getIdentifier()),
                        Permission.parsePermission(userAndRole.getRole().getName()));
            }
            else {
                log.warn("Unsupported user:" + userAndRole.getUser());
            }
        }
        if(log.isDebugEnabled()) {
            try {
                log.debug(list.toXml());
            }
            catch(ServiceException e) {
                log.error(e.getMessage());
            }
        }
        return list;
    }

    @Override
    public List<Acl.User> getAvailableAclUsers() {
        final List<Acl.User> users = new ArrayList<Acl.User>(Arrays.asList(
                new Acl.CanonicalUser(),
                new Acl.GroupUser(new AllAuthenticatedUsersGrantee().getIdentifier(), false),
                new Acl.GroupUser(new AllUsersGrantee().getIdentifier(), false))
        );
        users.add(new Acl.EmailUser() {
            @Override
            public String getPlaceholder() {
                return Locale.localizedString("Google Account Email Address", "S3");
            }
        });
        // Google Apps customers can associate their email accounts with an Internet domain name. When you do
        // this, each email account takes the form username@yourdomain.com. You can specify a scope by using
        // any Internet domain name that is associated with a Google Apps account.
        users.add(new Acl.DomainUser(StringUtils.EMPTY) {
            @Override
            public String getPlaceholder() {
                return Locale.localizedString("Google Apps Domain", "S3");
            }
        });
        users.add(new Acl.EmailGroupUser(StringUtils.EMPTY, true) {
            @Override
            public String getPlaceholder() {
                return Locale.localizedString("Google Group Email Address", "S3");
            }
        });
        return users;
    }

    @Override
    public List<Acl.Role> getAvailableAclRoles(final List<Path> files) {
        List<Acl.Role> roles = new ArrayList<Acl.Role>(Arrays.asList(
                new Acl.Role(org.jets3t.service.acl.Permission.PERMISSION_FULL_CONTROL.toString()),
                new Acl.Role(org.jets3t.service.acl.Permission.PERMISSION_READ.toString()))
        );
        for(Path file : files) {
            if(file.attributes().isVolume()) {
                // When applied to a bucket, this permission lets a user create objects, overwrite objects, and
                // delete objects in a bucket. This permission also lets a user list the contents of a bucket.
                // You cannot apply this permission to objects because bucket ACLs control who can upload,
                // overwrite, and delete objects. Also, you must grant READ permission if you grant WRITE permission.
                roles.add(new Acl.Role(org.jets3t.service.acl.Permission.PERMISSION_WRITE.toString()));
                break;
            }
        }
        return roles;
    }
}
