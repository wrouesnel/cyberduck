﻿// <Auto-Generated />
using NUnit.Framework;
using System;
using static NUnit.Framework.Assert;

namespace Ch.Cyberduck.Core
{
    [TestFixture]
    public class UtilsTest
    {
        static readonly Version Win10Release = new Version(10, 0, 10240);
        static readonly Version Win10November = new Version(10, 0, 10586);
        static readonly Version Win10Anniversary = new Version(10, 0, 14393);
        static readonly Version Win10Creators = new Version(10, 0, 15063);
        static readonly Version Win10FallCreators = new Version(10, 0, 16299);
        static readonly Version Win101803 = new Version(10, 0, 17134);
        static readonly Version Win101809 = new Version(10, 0, 17763);
        static readonly Version Win1019H1 = new Version(10, 0, 18362);
        static readonly Version Win1019H2 = new Version(10, 0, 18363);


        [Test]
        public void TestOSVersion()
        {
            var TestVersions = new[]
            {
                Utils.OSVersion.Windows10.Release,
                Utils.OSVersion.Windows10.V1511,
                Utils.OSVersion.Windows10.V1607,
                Utils.OSVersion.Windows10.V1703,
                Utils.OSVersion.Windows10.V1709,
                Utils.OSVersion.Windows10.V1803,
                Utils.OSVersion.Windows10.V1809,
                Utils.OSVersion.Windows10.V1903,
            };
            var OSVersions = new[]
            {
                Win10Release, Win10November, Win10Anniversary, Win10Creators, Win10FallCreators, Win101803, Win101809, Win1019H1, Win1019H2
            };

            // Test equal versions
            for (int i = TestVersions.Length - 1; i >= 0; i--)
            {
                var TestVersion = TestVersions[i];
                var OSVersion = OSVersions[i];
                IsTrue(Utils.OSVersion.TestOSVersion(TestVersion, OSVersion), $"{TestVersion} (OS: {OSVersion})");
            }

            // Test Greater OS-versions
            for (int i = OSVersions.Length - 1; i >= 0; i--)
            {
                var OSVersion = OSVersions[i];
                for (int j = TestVersions.Length - 1; j > i; j--)
                {
                    var TestVersion = TestVersions[j];
                    IsFalse(Utils.OSVersion.TestOSVersion(TestVersion, OSVersion), $"{TestVersion} (OS: {OSVersion})");
                }
            }

            // Test Lesser OS-versions
            for (int i = OSVersions.Length - 1; i >= 0; i--)
            {
                var OSVersion = OSVersions[i];
                for (int j = i - 1; j >= 0; j--)
                {
                    var TestVersion = TestVersions[j];
                    IsTrue(Utils.OSVersion.TestOSVersion(TestVersion, OSVersion), $"{TestVersion} (OS: {OSVersion})");
                }
            }
        }
    }
}
