package ch.cyberduck.core.transfer;

/*
 * Copyright (c) 2012 David Kocher. All rights reserved.
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
 * Bug fixes, suggestions and comments should be sent to:
 * dkocher@cyberduck.ch
 */

import ch.cyberduck.core.AbstractTestCase;
import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.DisabledListProgressListener;
import ch.cyberduck.core.DisabledProgressListener;
import ch.cyberduck.core.Host;
import ch.cyberduck.core.ListProgressListener;
import ch.cyberduck.core.Local;
import ch.cyberduck.core.LocalAttributes;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.SerializerFactory;
import ch.cyberduck.core.serializer.TransferDictionary;
import ch.cyberduck.core.synchronization.Comparison;
import ch.cyberduck.core.test.NullLocal;
import ch.cyberduck.core.test.NullSession;

import org.junit.Test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

/**
 * @version $Id$
 */
public class SyncTransferTest extends AbstractTestCase {

    @Test
    public void testAction() throws Exception {
        final Path p = new Path("t", EnumSet.of(Path.Type.directory));
        Transfer t = new SyncTransfer(new Host("t"), new TransferItem(p, new NullLocal("p", "t") {
            @Override
            public boolean exists() {
                return true;
            }

            @Override
            public AttributedList<Local> list() {
                return new AttributedList<Local>(Arrays.<Local>asList(new NullLocal("p", "a")));
            }
        }));
        final AtomicBoolean prompt = new AtomicBoolean();
        assertEquals(null, t.action(new NullSession(new Host("t")), false, false, new DisabledTransferPrompt() {
            @Override
            public TransferAction prompt(final TransferItem file) {
                prompt.set(true);
                return null;
            }
        }, new DisabledListProgressListener()));
        assertTrue(prompt.get());
    }

    @Test
    public void testSerializeLastSelectedAction() throws Exception {
        final Path p = new Path("t", EnumSet.of(Path.Type.directory));
        final SyncTransfer transfer = new SyncTransfer(new Host("t"), new TransferItem(p, new NullLocal("p", "t") {
            @Override
            public boolean exists() {
                return true;
            }

            @Override
            public AttributedList<Local> list() {
                return new AttributedList<Local>(Arrays.<Local>asList(new NullLocal("p", "a")));
            }
        }));
        transfer.action(null, true, false, new DisabledTransferPrompt() {
            @Override
            public TransferAction prompt(final TransferItem file) {
                return TransferAction.upload;
            }
        }, new DisabledListProgressListener());
        final Transfer serialized = new TransferDictionary().deserialize(transfer.serialize(SerializerFactory.get()));
        assertNotSame(transfer, serialized);
        assertEquals(TransferAction.upload, serialized.action(null, true, false, new DisabledTransferPrompt() {
            @Override
            public TransferAction prompt(final TransferItem file) {
                fail();
                return null;
            }
        }, new DisabledListProgressListener()));
    }


    @Test
    public void testFilterDownload() throws Exception {
        final Path p = new Path("t", EnumSet.of(Path.Type.directory));
        Transfer t = new SyncTransfer(new Host("t"), new TransferItem(p, new NullLocal(System.getProperty("java.io.tmpdir"), "t")));
        final TransferPathFilter filter = t.filter(new NullSession(new Host("t")) {
            @Override
            public AttributedList<Path> list(final Path file, final ListProgressListener listener) {
                return AttributedList.emptyList();
            }
        }, TransferAction.download, new DisabledProgressListener());
        final Path test = new Path(p, "a", EnumSet.of(Path.Type.file));
        assertFalse(filter.accept(test, new NullLocal(System.getProperty("java.io.tmpdir"), "a"),
                new TransferStatus().exists(true)));
    }

    @Test
    public void testFilterUpload() throws Exception {
        final Path p = new Path("t", EnumSet.of(Path.Type.directory));
        Transfer t = new SyncTransfer(new Host("t"), new TransferItem(p, new NullLocal(System.getProperty("java.io.tmpdir"), "t")));
        final TransferPathFilter filter = t.filter(new NullSession(new Host("t")), TransferAction.upload, new DisabledProgressListener());
        final Path test = new Path(p, "a", EnumSet.of(Path.Type.file));
        assertTrue(filter.accept(test, new NullLocal(System.getProperty("java.io.tmpdir"), "a") {
                    @Override
                    public boolean exists() {
                        return true;
                    }

                    @Override
                    public LocalAttributes attributes() {
                        return new LocalAttributes(path) {
                            @Override
                            public long getSize() {
                                return 1L;
                            }
                        };
                    }
                },
                new TransferStatus().exists(true)));
    }

    @Test
    public void testFilterMirror() throws Exception {
        final Path p = new Path("t", EnumSet.of(Path.Type.directory));
        SyncTransfer t = new SyncTransfer(new Host("t"), new TransferItem(p, new NullLocal(System.getProperty("java.io.tmpdir"), "t")));
        final TransferPathFilter filter = t.filter(new NullSession(new Host("t")), TransferAction.mirror, new DisabledProgressListener());
        assertTrue(filter.accept(new Path(p, "a", EnumSet.of(Path.Type.file)), new NullLocal(System.getProperty("java.io.tmpdir"), "a") {
                    @Override
                    public boolean exists() {
                        return true;
                    }

                    @Override
                    public LocalAttributes attributes() {
                        return new LocalAttributes(path) {
                            @Override
                            public long getSize() {
                                return 1L;
                            }
                        };
                    }
                },
                new TransferStatus().exists(true)));
        assertTrue(filter.accept(new Path(p, "b", EnumSet.of(Path.Type.file)), new NullLocal(System.getProperty("java.io.tmpdir"), "a") {
                    @Override
                    public boolean exists() {
                        return true;
                    }

                    @Override
                    public LocalAttributes attributes() {
                        return new LocalAttributes(path) {
                            @Override
                            public long getSize() {
                                return 0L;
                            }
                        };
                    }
                },
                new TransferStatus().exists(true)));
        assertEquals(Comparison.local, t.compare(new TransferItem(new Path(p, "a", EnumSet.of(Path.Type.file)), new NullLocal(System.getProperty("java.io.tmpdir"), "a"))));
        assertEquals(Comparison.remote, t.compare(new TransferItem(new Path(p, "b", EnumSet.of(Path.Type.file)), new NullLocal(System.getProperty("java.io.tmpdir"), "a"))));
    }

    @Test
    public void testChildrenRemoteAndLocalExist() throws Exception {
        final NullLocal directory = new NullLocal(System.getProperty("java.io.tmpdir"), "t") {
            @Override
            public AttributedList<Local> list() {
                final AttributedList<Local> list = new AttributedList<Local>();
                list.add(new NullLocal(this, "a"));
                return list;
            }
        };
        final Path root = new Path("t", EnumSet.of(Path.Type.directory));
        final Path remote = new Path(root, "a", EnumSet.of(Path.Type.file));
        final NullSession session = new NullSession(new Host("t")) {
            @Override
            public AttributedList<Path> list(final Path file, final ListProgressListener listener) {
                final AttributedList<Path> list = new AttributedList<Path>();
                if(file.equals(root.getParent())) {
                    list.add(root);
                }
                else {
                    list.add(remote);
                }
                return list;
            }
        };
        directory.mkdir();
        Transfer t = new SyncTransfer(new Host("t"), new TransferItem(root, directory));
        final List<TransferItem> list = t.list(session, root, directory, new DisabledListProgressListener());
        assertEquals(1, list.size());
    }

    @Test
    public void testChildrenLocalOnly() throws Exception {
        final Path root = new Path("t", EnumSet.of(Path.Type.directory));
        final NullSession session = new NullSession(new Host("t")) {
            @Override
            public AttributedList<Path> list(final Path file, final ListProgressListener listener) {
                return AttributedList.emptyList();
            }
        };
        final NullLocal directory = new NullLocal(System.getProperty("java.io.tmpdir"), "t") {
            @Override
            public AttributedList<Local> list() {
                final AttributedList<Local> list = new AttributedList<Local>();
                list.add(new NullLocal(System.getProperty("java.io.tmpdir") + "/t", "a") {
                    @Override
                    public boolean exists() {
                        return true;
                    }
                });
                return list;
            }
        };
        directory.mkdir();
        Transfer t = new SyncTransfer(new Host("t"), new TransferItem(root, directory));
        final List<TransferItem> list = t.list(session, root, directory, new DisabledListProgressListener());
        assertEquals(1, list.size());
        final NullLocal local = new NullLocal(System.getProperty("java.io.tmpdir"), "a") {
            @Override
            public boolean exists() {
                return true;
            }
        };
        assertFalse(t.filter(session, TransferAction.download, new DisabledProgressListener()).accept(root, local, new TransferStatus().exists(true)));
        assertTrue(t.filter(session, TransferAction.upload, new DisabledProgressListener()).accept(root, local, new TransferStatus().exists(true)));
        assertTrue(t.filter(session, TransferAction.mirror, new DisabledProgressListener()).accept(root, local, new TransferStatus().exists(true)));
    }

    @Test
    public void testChildrenRemoteOnly() throws Exception {
        final Path root = new Path("t", EnumSet.of(Path.Type.directory));
        final Path a = new Path(root, "a", EnumSet.of(Path.Type.file));
        final NullLocal directory = new NullLocal(System.getProperty("java.io.tmpdir"), "t") {
            @Override
            public AttributedList<Local> list() {
                return new AttributedList<Local>();
            }
        };
        directory.mkdir();
        final NullSession session = new NullSession(new Host("t")) {
            @Override
            public AttributedList<Path> list(final Path file, final ListProgressListener listener) {
                final AttributedList<Path> list = new AttributedList<Path>();
                if(file.equals(root.getParent())) {
                    list.add(root);
                }
                else {
                    list.add(a);
                }
                return list;
            }
        };
        final Transfer t = new SyncTransfer(new Host("t"), new TransferItem(root, directory));
        final List<TransferItem> list = t.list(session, root, directory, new DisabledListProgressListener());
        assertEquals(1, list.size());
        final NullLocal local = new NullLocal(directory, "a") {
            @Override
            public boolean exists() {
                return false;
            }
        };
        assertTrue(t.filter(session, TransferAction.download, new DisabledProgressListener()).accept(root, directory, new TransferStatus().exists(true)));
        assertTrue(t.filter(session, TransferAction.upload, new DisabledProgressListener()).accept(root, directory, new TransferStatus().exists(true)));
        assertTrue(t.filter(session, TransferAction.mirror, new DisabledProgressListener()).accept(root, directory, new TransferStatus().exists(true)));
        assertTrue(t.filter(session, TransferAction.download, new DisabledProgressListener()).accept(a, local, new TransferStatus().exists(true)));
        // Because root is directory
        assertTrue(t.filter(session, TransferAction.upload, new DisabledProgressListener()).accept(root, directory, new TransferStatus().exists(true)));
        assertFalse(t.filter(session, TransferAction.upload, new DisabledProgressListener()).accept(a, local, new TransferStatus().exists(true)));
    }
}
