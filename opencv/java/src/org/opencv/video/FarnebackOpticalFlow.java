//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.video;

// C++: class FarnebackOpticalFlow

/**
 * Class computing a dense optical flow using the Gunnar Farneback's algorithm.
 */
public class FarnebackOpticalFlow extends DenseOpticalFlow {

    protected FarnebackOpticalFlow(long addr) {
        super(addr);
    }

    // internal usage only
    public static FarnebackOpticalFlow __fromPtr__(long addr) {
        return new FarnebackOpticalFlow(addr);
    }

    //
    // C++: static Ptr_FarnebackOpticalFlow cv::FarnebackOpticalFlow::create(int numLevels = 5, double pyrScale = 0.5, bool fastPyramids = false, int winSize = 13, int numIters = 10, int polyN = 5, double polySigma = 1.1, int flags = 0)
    //

    public static FarnebackOpticalFlow create(int numLevels, double pyrScale, boolean fastPyramids, int winSize, int numIters, int polyN, double polySigma, int flags) {
        return FarnebackOpticalFlow.__fromPtr__(create_0(numLevels, pyrScale, fastPyramids, winSize, numIters, polyN, polySigma, flags));
    }

    public static FarnebackOpticalFlow create(int numLevels, double pyrScale, boolean fastPyramids, int winSize, int numIters, int polyN, double polySigma) {
        return FarnebackOpticalFlow.__fromPtr__(create_1(numLevels, pyrScale, fastPyramids, winSize, numIters, polyN, polySigma));
    }

    public static FarnebackOpticalFlow create(int numLevels, double pyrScale, boolean fastPyramids, int winSize, int numIters, int polyN) {
        return FarnebackOpticalFlow.__fromPtr__(create_2(numLevels, pyrScale, fastPyramids, winSize, numIters, polyN));
    }

    public static FarnebackOpticalFlow create(int numLevels, double pyrScale, boolean fastPyramids, int winSize, int numIters) {
        return FarnebackOpticalFlow.__fromPtr__(create_3(numLevels, pyrScale, fastPyramids, winSize, numIters));
    }

    public static FarnebackOpticalFlow create(int numLevels, double pyrScale, boolean fastPyramids, int winSize) {
        return FarnebackOpticalFlow.__fromPtr__(create_4(numLevels, pyrScale, fastPyramids, winSize));
    }

    public static FarnebackOpticalFlow create(int numLevels, double pyrScale, boolean fastPyramids) {
        return FarnebackOpticalFlow.__fromPtr__(create_5(numLevels, pyrScale, fastPyramids));
    }

    public static FarnebackOpticalFlow create(int numLevels, double pyrScale) {
        return FarnebackOpticalFlow.__fromPtr__(create_6(numLevels, pyrScale));
    }

    public static FarnebackOpticalFlow create(int numLevels) {
        return FarnebackOpticalFlow.__fromPtr__(create_7(numLevels));
    }

    public static FarnebackOpticalFlow create() {
        return FarnebackOpticalFlow.__fromPtr__(create_8());
    }


    //
    // C++:  bool cv::FarnebackOpticalFlow::getFastPyramids()
    //

    // C++: static Ptr_FarnebackOpticalFlow cv::FarnebackOpticalFlow::create(int numLevels = 5, double pyrScale = 0.5, bool fastPyramids = false, int winSize = 13, int numIters = 10, int polyN = 5, double polySigma = 1.1, int flags = 0)
    private static native long create_0(int numLevels, double pyrScale, boolean fastPyramids, int winSize, int numIters, int polyN, double polySigma, int flags);


    //
    // C++:  double cv::FarnebackOpticalFlow::getPolySigma()
    //

    private static native long create_1(int numLevels, double pyrScale, boolean fastPyramids, int winSize, int numIters, int polyN, double polySigma);


    //
    // C++:  double cv::FarnebackOpticalFlow::getPyrScale()
    //

    private static native long create_2(int numLevels, double pyrScale, boolean fastPyramids, int winSize, int numIters, int polyN);


    //
    // C++:  int cv::FarnebackOpticalFlow::getFlags()
    //

    private static native long create_3(int numLevels, double pyrScale, boolean fastPyramids, int winSize, int numIters);


    //
    // C++:  int cv::FarnebackOpticalFlow::getNumIters()
    //

    private static native long create_4(int numLevels, double pyrScale, boolean fastPyramids, int winSize);


    //
    // C++:  int cv::FarnebackOpticalFlow::getNumLevels()
    //

    private static native long create_5(int numLevels, double pyrScale, boolean fastPyramids);


    //
    // C++:  int cv::FarnebackOpticalFlow::getPolyN()
    //

    private static native long create_6(int numLevels, double pyrScale);


    //
    // C++:  int cv::FarnebackOpticalFlow::getWinSize()
    //

    private static native long create_7(int numLevels);


    //
    // C++:  void cv::FarnebackOpticalFlow::setFastPyramids(bool fastPyramids)
    //

    private static native long create_8();


    //
    // C++:  void cv::FarnebackOpticalFlow::setFlags(int flags)
    //

    // C++:  bool cv::FarnebackOpticalFlow::getFastPyramids()
    private static native boolean getFastPyramids_0(long nativeObj);


    //
    // C++:  void cv::FarnebackOpticalFlow::setNumIters(int numIters)
    //

    // C++:  double cv::FarnebackOpticalFlow::getPolySigma()
    private static native double getPolySigma_0(long nativeObj);


    //
    // C++:  void cv::FarnebackOpticalFlow::setNumLevels(int numLevels)
    //

    // C++:  double cv::FarnebackOpticalFlow::getPyrScale()
    private static native double getPyrScale_0(long nativeObj);


    //
    // C++:  void cv::FarnebackOpticalFlow::setPolyN(int polyN)
    //

    // C++:  int cv::FarnebackOpticalFlow::getFlags()
    private static native int getFlags_0(long nativeObj);


    //
    // C++:  void cv::FarnebackOpticalFlow::setPolySigma(double polySigma)
    //

    // C++:  int cv::FarnebackOpticalFlow::getNumIters()
    private static native int getNumIters_0(long nativeObj);


    //
    // C++:  void cv::FarnebackOpticalFlow::setPyrScale(double pyrScale)
    //

    // C++:  int cv::FarnebackOpticalFlow::getNumLevels()
    private static native int getNumLevels_0(long nativeObj);


    //
    // C++:  void cv::FarnebackOpticalFlow::setWinSize(int winSize)
    //

    // C++:  int cv::FarnebackOpticalFlow::getPolyN()
    private static native int getPolyN_0(long nativeObj);

    // C++:  int cv::FarnebackOpticalFlow::getWinSize()
    private static native int getWinSize_0(long nativeObj);

    // C++:  void cv::FarnebackOpticalFlow::setFastPyramids(bool fastPyramids)
    private static native void setFastPyramids_0(long nativeObj, boolean fastPyramids);

    // C++:  void cv::FarnebackOpticalFlow::setFlags(int flags)
    private static native void setFlags_0(long nativeObj, int flags);

    // C++:  void cv::FarnebackOpticalFlow::setNumIters(int numIters)
    private static native void setNumIters_0(long nativeObj, int numIters);

    // C++:  void cv::FarnebackOpticalFlow::setNumLevels(int numLevels)
    private static native void setNumLevels_0(long nativeObj, int numLevels);

    // C++:  void cv::FarnebackOpticalFlow::setPolyN(int polyN)
    private static native void setPolyN_0(long nativeObj, int polyN);

    // C++:  void cv::FarnebackOpticalFlow::setPolySigma(double polySigma)
    private static native void setPolySigma_0(long nativeObj, double polySigma);

    // C++:  void cv::FarnebackOpticalFlow::setPyrScale(double pyrScale)
    private static native void setPyrScale_0(long nativeObj, double pyrScale);

    // C++:  void cv::FarnebackOpticalFlow::setWinSize(int winSize)
    private static native void setWinSize_0(long nativeObj, int winSize);

    // native support for java finalize()
    private static native void delete(long nativeObj);

    public boolean getFastPyramids() {
        return getFastPyramids_0(nativeObj);
    }

    public void setFastPyramids(boolean fastPyramids) {
        setFastPyramids_0(nativeObj, fastPyramids);
    }

    public double getPolySigma() {
        return getPolySigma_0(nativeObj);
    }

    public void setPolySigma(double polySigma) {
        setPolySigma_0(nativeObj, polySigma);
    }

    public double getPyrScale() {
        return getPyrScale_0(nativeObj);
    }

    public void setPyrScale(double pyrScale) {
        setPyrScale_0(nativeObj, pyrScale);
    }

    public int getFlags() {
        return getFlags_0(nativeObj);
    }

    public void setFlags(int flags) {
        setFlags_0(nativeObj, flags);
    }

    public int getNumIters() {
        return getNumIters_0(nativeObj);
    }

    public void setNumIters(int numIters) {
        setNumIters_0(nativeObj, numIters);
    }

    public int getNumLevels() {
        return getNumLevels_0(nativeObj);
    }

    public void setNumLevels(int numLevels) {
        setNumLevels_0(nativeObj, numLevels);
    }

    public int getPolyN() {
        return getPolyN_0(nativeObj);
    }

    public void setPolyN(int polyN) {
        setPolyN_0(nativeObj, polyN);
    }

    public int getWinSize() {
        return getWinSize_0(nativeObj);
    }

    public void setWinSize(int winSize) {
        setWinSize_0(nativeObj, winSize);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }

}
