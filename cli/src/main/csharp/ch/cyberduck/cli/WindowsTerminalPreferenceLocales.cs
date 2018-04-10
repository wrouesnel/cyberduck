﻿//
// Copyright (c) 2010-2018 iterate GmbH. All rights reserved.
// http://cyberduck.io/
//
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// Bug fixes, suggestions and comments should be sent to:
// feedback@cyberduck.io
//

using Ch.Cyberduck.Core.I18n;
using java.util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ch.Cyberduck.Cli
{
    public class WindowsTerminalPreferenceLocales : PreferenceLocales
    {
        public override List applicationLocales() => Collections.singletonList("en");

        public override List systemLocales() => Collections.singletonList("en");
    }
}
