package ch.cyberduck.ui.cocoa.application;

/*
 * Copyright (c) 2002-2009 David Kocher. All rights reserved.
 *
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

import ch.cyberduck.ui.cocoa.foundation.NSAttributedString;
import ch.cyberduck.ui.cocoa.foundation.NSObject;

import org.rococoa.Rococoa;
import org.rococoa.cocoa.CGFloat;

public interface NSButtonCell extends NSActionCell {
    _Class CLASS = org.rococoa.Rococoa.createClass("NSButtonCell", _Class.class);

    public static class Factory {
        public static NSButtonCell create() {
            return Rococoa.cast(CLASS.alloc().init().autorelease(), NSButtonCell.class);
        }
    }

    public interface _Class extends org.rococoa.NSClass {
        NSButtonCell alloc();
    }

    public abstract NSButtonCell init();

    /**
     * was NSMomentaryPushButton<br>
     * <i>native declaration : :12</i>
     */
    public static final int NSMomentaryLightButton = 0;
    /// <i>native declaration : :13</i>
    public static final int NSPushOnPushOffButton = 1;
    /// <i>native declaration : :14</i>
    public static final int NSToggleButton = 2;
    /// <i>native declaration : :15</i>
    public static final int NSSwitchButton = 3;
    /// <i>native declaration : :16</i>
    public static final int NSRadioButton = 4;
    /// <i>native declaration : :17</i>
    public static final int NSMomentaryChangeButton = 5;
    /// <i>native declaration : :18</i>
    public static final int NSOnOffButton = 6;
    /**
     * was NSMomentaryLight<br>
     * <i>native declaration : :19</i>
     */
    public static final int NSMomentaryPushInButton = 7;
    /// <i>native declaration : :24</i>
    public static final int NSMomentaryPushButton = 0;
    /// <i>native declaration : :25</i>
    public static final int NSMomentaryLight = 7;
    /// <i>native declaration : :32</i>
    public static final int NSRoundedBezelStyle = 1;
    /// <i>native declaration : :33</i>
    public static final int NSRegularSquareBezelStyle = 2;
    /// <i>native declaration : :34</i>
    public static final int NSThickSquareBezelStyle = 3;
    /// <i>native declaration : :35</i>
    public static final int NSThickerSquareBezelStyle = 4;
    /// <i>native declaration : :37</i>
    public static final int NSDisclosureBezelStyle = 5;
    /// <i>native declaration : :39</i>
    public static final int NSShadowlessSquareBezelStyle = 6;
    /// <i>native declaration : :40</i>
    public static final int NSCircularBezelStyle = 7;
    /// <i>native declaration : :42</i>
    public static final int NSTexturedSquareBezelStyle = 8;
    /// <i>native declaration : :43</i>
    public static final int NSHelpButtonBezelStyle = 9;
    /// <i>native declaration : :46</i>
    public static final int NSSmallSquareBezelStyle = 10;
    /// <i>native declaration : :47</i>
    public static final int NSTexturedRoundedBezelStyle = 11;
    /// <i>native declaration : :48</i>
    public static final int NSRoundRectBezelStyle = 12;
    /// <i>native declaration : :49</i>
    public static final int NSRecessedBezelStyle = 13;
    /// <i>native declaration : :50</i>
    public static final int NSRoundedDisclosureBezelStyle = 14;
    /// <i>native declaration : :55</i>
    public static final int NSSmallIconButtonBezelStyle = 2;
    /// <i>native declaration : :200</i>
    public static final int NSGradientNone = 0;
    /// <i>native declaration : :201</i>
    public static final int NSGradientConcaveWeak = 1;
    /// <i>native declaration : :202</i>
    public static final int NSGradientConcaveStrong = 2;
    /// <i>native declaration : :203</i>
    public static final int NSGradientConvexWeak = 3;
    /// <i>native declaration : :204</i>
    public static final int NSGradientConvexStrong = 4;

    /**
     * Original signature : <code>NSString* title()</code><br>
     * <i>native declaration : :143</i>
     */
    String title();

    /**
     * Original signature : <code>void setTitle(NSString*)</code><br>
     * <i>native declaration : :144</i>
     */
    void setTitle(String aString);

    /**
     * Original signature : <code>NSString* alternateTitle()</code><br>
     * <i>native declaration : :145</i>
     */
    String alternateTitle();

    /**
     * Original signature : <code>void setAlternateTitle(NSString*)</code><br>
     * <i>native declaration : :146</i>
     */
    void setAlternateTitle(String aString);

    /**
     * Original signature : <code>NSImage* alternateImage()</code><br>
     * <i>native declaration : :148</i>
     */
    NSImage alternateImage();

    /**
     * Original signature : <code>void setAlternateImage(NSImage*)</code><br>
     * <i>native declaration : :149</i>
     */
    void setAlternateImage(NSImage image);

    /**
     * Original signature : <code>imagePosition()</code><br>
     * <i>native declaration : :150</i>
     */
    com.sun.jna.Pointer imagePosition();
    /**
     * <i>native declaration : :151</i><br>
     * Conversion Error : /// Original signature : <code>void setImagePosition(null)</code><br>
     * - (void)setImagePosition:(null)aPosition; (Argument aPosition cannot be converted)
     */
    /**
     * Original signature : <code>imageScaling()</code><br>
     * <i>native declaration : :153</i>
     */
    com.sun.jna.Pointer imageScaling();
    /**
     * <i>native declaration : :154</i><br>
     * Conversion Error : /// Original signature : <code>void setImageScaling(null)</code><br>
     * - (void)setImageScaling:(null)scaling; (Argument scaling cannot be converted)
     */
    /**
     * Original signature : <code>NSInteger highlightsBy()</code><br>
     * <i>native declaration : :157</i>
     */
    int highlightsBy();

    /**
     * Original signature : <code>void setHighlightsBy(NSInteger)</code><br>
     * <i>native declaration : :158</i>
     */
    void setHighlightsBy(int aType);

    /**
     * Original signature : <code>NSInteger showsStateBy()</code><br>
     * <i>native declaration : :159</i>
     */
    int showsStateBy();

    /**
     * Original signature : <code>void setShowsStateBy(NSInteger)</code><br>
     * <i>native declaration : :160</i>
     */
    void setShowsStateBy(int aType);

    /**
     * Original signature : <code>void setButtonType(NSButtonType)</code><br>
     * <i>native declaration : :161</i>
     */
    void setButtonType(int aType);

    /**
     * Original signature : <code>BOOL isOpaque()</code><br>
     * <i>native declaration : :162</i>
     */
    boolean isOpaque();

    /**
     * Original signature : <code>void setFont(NSFont*)</code><br>
     * <i>native declaration : :163</i>
     */
    void setFont(NSFont fontObj);

    /**
     * Original signature : <code>BOOL isTransparent()</code><br>
     * <i>native declaration : :164</i>
     */
    boolean isTransparent();

    /**
     * Original signature : <code>void setTransparent(BOOL)</code><br>
     * <i>native declaration : :165</i>
     */
    void setTransparent(boolean flag);

    /**
     * Original signature : <code>void setPeriodicDelay(float, float)</code><br>
     * <i>native declaration : :166</i>
     */
    void setPeriodicDelay_interval(float delay, float interval);

    /**
     * Original signature : <code>void getPeriodicDelay(float*, float*)</code><br>
     * <i>native declaration : :167</i><br>
     *
     * @deprecated use the safer method {@link #getPeriodicDelay_interval(java.nio.FloatBuffer, java.nio.FloatBuffer)} instead
     */
    @java.lang.Deprecated
    void getPeriodicDelay_interval(com.sun.jna.ptr.FloatByReference delay, com.sun.jna.ptr.FloatByReference interval);

    /**
     * Original signature : <code>void getPeriodicDelay(float*, float*)</code><br>
     * <i>native declaration : :167</i>
     */
    void getPeriodicDelay_interval(java.nio.FloatBuffer delay, java.nio.FloatBuffer interval);

    /**
     * Original signature : <code>NSString* keyEquivalent()</code><br>
     * <i>native declaration : :168</i>
     */
    String keyEquivalent();

    /**
     * Original signature : <code>void setKeyEquivalent(NSString*)</code><br>
     * <i>native declaration : :169</i>
     */
    void setKeyEquivalent(String aKeyEquivalent);

    /**
     * Original signature : <code>NSUInteger keyEquivalentModifierMask()</code><br>
     * <i>native declaration : :170</i>
     */
    int keyEquivalentModifierMask();

    /**
     * Original signature : <code>void setKeyEquivalentModifierMask(NSUInteger)</code><br>
     * <i>native declaration : :171</i>
     */
    void setKeyEquivalentModifierMask(int mask);

    /**
     * Original signature : <code>NSFont* keyEquivalentFont()</code><br>
     * <i>native declaration : :172</i>
     */
    NSFont keyEquivalentFont();

    /**
     * Original signature : <code>void setKeyEquivalentFont(NSFont*)</code><br>
     * <i>native declaration : :173</i>
     */
    void setKeyEquivalentFont(NSFont fontObj);

    /**
     * Original signature : <code>void setKeyEquivalentFont(NSString*, CGFloat)</code><br>
     * <i>native declaration : :174</i>
     */
    void setKeyEquivalentFont_size(String fontName, CGFloat fontSize);

    /**
     * Original signature : <code>void performClick(id)</code><br>
     * Significant NSCell override, actually clicks itself.<br>
     * <i>native declaration : :175</i>
     */
    void performClick(NSObject sender);
    /**
     * <i>native declaration : :178</i><br>
     * Conversion Error : /// Original signature : <code>void drawImage(NSImage*, null, NSView*)</code><br>
     * - (void)drawImage:(NSImage*)image withFrame:(null)frame inView:(NSView*)controlView; (Argument frame cannot be converted)
     */
    /**
     * <i>native declaration : :179</i><br>
     * Conversion Error : /// Original signature : <code>drawTitle(NSAttributedString*, null, NSView*)</code><br>
     * - (null)drawTitle:(NSAttributedString*)title withFrame:(null)frame inView:(NSView*)controlView; (Argument frame cannot be converted)
     */
    /**
     * <i>native declaration : :180</i><br>
     * Conversion Error : /// Original signature : <code>void drawBezelWithFrame(null, NSView*)</code><br>
     * - (void)drawBezelWithFrame:(null)frame inView:(NSView*)controlView; (Argument frame cannot be converted)
     */
    /**
     * Original signature : <code>void setTitleWithMnemonic(NSString*)</code><br>
     * <i>from NSKeyboardUI native declaration : :185</i>
     */
    void setTitleWithMnemonic(com.sun.jna.Pointer stringWithAmpersand);

    /**
     * Original signature : <code>void setAlternateTitleWithMnemonic(NSString*)</code><br>
     * <i>from NSKeyboardUI native declaration : :186</i>
     */
    void setAlternateTitleWithMnemonic(com.sun.jna.Pointer stringWithAmpersand);

    /**
     * Original signature : <code>void setAlternateMnemonicLocation(NSUInteger)</code><br>
     * <i>from NSKeyboardUI native declaration : :187</i>
     */
    void setAlternateMnemonicLocation(int location);

    /**
     * Original signature : <code>NSUInteger alternateMnemonicLocation()</code><br>
     * <i>from NSKeyboardUI native declaration : :188</i>
     */
    int alternateMnemonicLocation();

    /**
     * Original signature : <code>NSString* alternateMnemonic()</code><br>
     * <i>from NSKeyboardUI native declaration : :189</i>
     */
    com.sun.jna.Pointer alternateMnemonic();

    /**
     * Original signature : <code>NSGradientType gradientType()</code><br>
     * <i>from NSButtonCellExtensions native declaration : :209</i>
     */
    int gradientType();

    /**
     * Original signature : <code>void setGradientType(NSGradientType)</code><br>
     * <i>from NSButtonCellExtensions native declaration : :210</i>
     */
    void setGradientType(int type);

    /**
     * Radio buttons and switches use (imageDimsWhenDisabled == NO) so only their text is dimmed.<br>
     * Original signature : <code>void setImageDimsWhenDisabled(BOOL)</code><br>
     * <i>from NSButtonCellExtensions native declaration : :214</i>
     */
    void setImageDimsWhenDisabled(boolean flag);

    /**
     * Original signature : <code>BOOL imageDimsWhenDisabled()</code><br>
     * <i>from NSButtonCellExtensions native declaration : :215</i>
     */
    boolean imageDimsWhenDisabled();

    /**
     * Original signature : <code>void setShowsBorderOnlyWhileMouseInside(BOOL)</code><br>
     * <i>from NSButtonCellExtensions native declaration : :217</i>
     */
    void setShowsBorderOnlyWhileMouseInside(boolean show);

    /**
     * Original signature : <code>BOOL showsBorderOnlyWhileMouseInside()</code><br>
     * <i>from NSButtonCellExtensions native declaration : :218</i>
     */
    boolean showsBorderOnlyWhileMouseInside();

    /**
     * Original signature : <code>void mouseEntered(NSEvent*)</code><br>
     * <i>from NSButtonCellExtensions native declaration : :220</i>
     */
    void mouseEntered(NSEvent event);

    /**
     * Original signature : <code>void mouseExited(NSEvent*)</code><br>
     * <i>from NSButtonCellExtensions native declaration : :221</i>
     */
    void mouseExited(NSEvent event);

    /**
     * Original signature : <code>NSColor* backgroundColor()</code><br>
     * <i>from NSButtonCellExtensions native declaration : :224</i>
     */
    NSColor backgroundColor();

    /**
     * Original signature : <code>void setBackgroundColor(NSColor*)</code><br>
     * <i>from NSButtonCellExtensions native declaration : :225</i>
     */
    void setBackgroundColor(NSColor color);

    /**
     * Original signature : <code>NSAttributedString* attributedTitle()</code><br>
     * <i>from NSButtonCellAttributedStringMethods native declaration : :231</i>
     */
    com.sun.jna.Pointer attributedTitle();

    /**
     * Original signature : <code>void setAttributedTitle(NSAttributedString*)</code><br>
     * <i>from NSButtonCellAttributedStringMethods native declaration : :232</i>
     */
    void setAttributedTitle(NSAttributedString obj);

    /**
     * Original signature : <code>NSAttributedString* attributedAlternateTitle()</code><br>
     * <i>from NSButtonCellAttributedStringMethods native declaration : :233</i>
     */
    NSAttributedString attributedAlternateTitle();

    /**
     * Original signature : <code>void setAttributedAlternateTitle(NSAttributedString*)</code><br>
     * <i>from NSButtonCellAttributedStringMethods native declaration : :234</i>
     */
    void setAttributedAlternateTitle(com.sun.jna.Pointer obj);

    /**
     * Original signature : <code>void setBezelStyle(NSBezelStyle)</code><br>
     * <i>from NSButtonCellBezelStyles native declaration : :239</i>
     */
    void setBezelStyle(int bezelStyle);

    /**
     * Original signature : <code>NSBezelStyle bezelStyle()</code><br>
     * <i>from NSButtonCellBezelStyles native declaration : :240</i>
     */
    int bezelStyle();

    /**
     * Original signature : <code>void setSound(NSSound*)</code><br>
     * <i>from NSButtonCellSoundExtensions native declaration : :245</i>
     */
    void setSound(com.sun.jna.Pointer aSound);

    /**
     * Original signature : <code>NSSound* sound()</code><br>
     * <i>from NSButtonCellSoundExtensions native declaration : :246</i>
     */
    com.sun.jna.Pointer sound();
}