package ch.cyberduck.core.worker;

/*
 * Copyright (c) 2002-2016 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
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
 */

import ch.cyberduck.core.Cache;
import ch.cyberduck.core.Host;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.ProgressListener;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.threading.AbstractRetryCallable;
import ch.cyberduck.core.threading.BackgroundActionState;
import ch.cyberduck.core.transfer.Transfer;
import ch.cyberduck.core.transfer.TransferItem;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.log4j.Logger;

public abstract class RetryTransferCallable extends AbstractRetryCallable<TransferStatus> implements TransferWorker.TransferCallable {
    private static final Logger log = Logger.getLogger(RetryTransferCallable.class);

    private final Transfer transfer;
    private final TransferItem item;

    public RetryTransferCallable(final Transfer transfer, final TransferItem item, final Host host, final int retry, final int delay) {
        super(host, retry, delay);
        this.transfer = transfer;
        this.item = item;
    }

    @Override
    public boolean retry(final BackgroundException failure, final ProgressListener progress, final BackgroundActionState cancel) {
        if(super.retry(failure, progress, cancel)) {
            Path next = item.remote;
            while(!next.isRoot()) {
                log.warn(String.format("Reset version attributes of %s", item.remote));
                next.attributes().setVersionId(null);
                next = next.getParent();
            }
            final Cache<Path> cache = transfer.getCache();
            cache.clear();
            return true;
        }
        return false;
    }
}
