/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AugustPractice;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import org.opencv.core.Core;
import static org.opencv.core.Core.inRange;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author ahmad
 */
public class MiscMethods {

    public static double brightnessFactor = 1.5;
    public static double gammaFactor = 0.25;
    public static double gammaCorrection = 1 / gammaFactor;
    public static int[] hue = {50, 75};
    public static int[] sat = {75, 200};
    public static int[] val = {0, 75};

    public static BufferedImage MatConvert(Mat mat) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        Mat testColor = imread("Markings.jpg", CV_LOAD_IMAGE_COLOR);

        BufferedImage resultImage = new BufferedImage(mat.width(),
                mat.height(), BufferedImage.TYPE_3BYTE_BGR);

        byte[] data = ((DataBufferByte) resultImage.getRaster().getDataBuffer()).getData();

//        System.out.println(data[1]);
        mat.get(0, 0, data);

        return resultImage;
    }

    public static BufferedImage MatGrayConvert(Mat mat) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        Mat testColor = imread("Markings.jpg", CV_LOAD_IMAGE_COLOR);

        BufferedImage resultImage = new BufferedImage(mat.width(),
                mat.height(), BufferedImage.TYPE_BYTE_GRAY);

        byte[] data = ((DataBufferByte) resultImage.getRaster().getDataBuffer()).getData();
        mat.get(0, 0, data);

        return resultImage;
    }

    public static Mat process(Mat input) {
        // Step HSV_Threshold0:
        Mat output = input;
        double[] hsvThresholdHue = {50.0, 180.0};
        double[] hsvThresholdSaturation = {0.0, 255.0};
        double[] hsvThresholdValue = {0.0, 255.0};
        hsvThreshold(input, hsvThresholdHue, hsvThresholdSaturation, hsvThresholdValue, output);

        return output;

    }

    public static Mat blur(Mat input, double doubleRadius) {
        int radius = (int) (doubleRadius + 0.5);
        int kernelSize;

        kernelSize = 2 * radius + 1;
        Mat output = input;
        Imgproc.medianBlur(input, output, kernelSize);
        return output;

    }

    public static Mat cvMedianblur(Mat src, double kSize, Mat dst) {
        Imgproc.medianBlur(src, dst, (int) kSize);
        return dst;
    }

    private static void hsvThreshold(Mat input, double[] hue, double[] sat, double[] val,
            Mat out) {
        Imgproc.cvtColor(input, out, Imgproc.COLOR_RGB2HSV);
        Core.inRange(out, new Scalar(hue[0], sat[0], val[0]),
                new Scalar(hue[1], sat[1], val[1]), out);
    }

    public static Mat ThresholdHSV(Mat mat) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

//        Mat mat1 = mat;
        Mat hsvFrame = new Mat(mat.rows(), mat.cols(), CvType.CV_8U, new Scalar(3));

        Imgproc.cvtColor(mat, hsvFrame, Imgproc.COLOR_RGB2HSV, 3);

        Mat middle = new Mat(mat.rows(), mat.cols(), CvType.CV_8U, new Scalar(3));

        inRange(hsvFrame, new Scalar(hue[0], sat[0], val[0]),
                new Scalar(hue[1], sat[1], val[1]), middle);

        Mat output = new Mat(middle.rows(), middle.cols(), CvType.CV_8U, new Scalar(3));

        Core.bitwise_and(mat, mat, output, middle);
//        System.out.println(mat1.rows());
        Mat finale = new Mat(middle.rows(), middle.cols(), CvType.CV_8U, new Scalar(3));
        Imgproc.cvtColor(output, finale, Imgproc.COLOR_BGR2GRAY);

        return finale;
    }
    
    public static Mat ThresholdHSV(Mat mat, int[] hue, int[] sat, int[] val) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

//        Mat mat1 = mat;
        Mat hsvFrame = new Mat(mat.rows(), mat.cols(), CvType.CV_8U, new Scalar(3));

        Imgproc.cvtColor(mat, hsvFrame, Imgproc.COLOR_RGB2HSV, 3);

        Mat middle = new Mat(mat.rows(), mat.cols(), CvType.CV_8U, new Scalar(3));

        inRange(hsvFrame, new Scalar(hue[0], sat[0], val[0]),
                new Scalar(hue[1], sat[1], val[1]), middle);

        Mat output = new Mat(middle.rows(), middle.cols(), CvType.CV_8U, new Scalar(3));

        Core.bitwise_and(mat, mat, output, middle);
//        System.out.println(mat1.rows());
        Mat finale = new Mat(middle.rows(), middle.cols(), CvType.CV_8U, new Scalar(3));
        Imgproc.cvtColor(output, finale, Imgproc.COLOR_BGR2GRAY);

        return finale;
    }

    public static BufferedImage setBrightness(BufferedImage input) {

        int height = input.getHeight();
        int width = input.getWidth();
        int rgb = 0;
        int red = 0, blue = 0, green = 0;

        BufferedImage output = new BufferedImage(width, height, input.getType());
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                rgb = input.getRGB(i, j);

                red = (int) (((rgb >> 16) & 0x000000FF) * brightnessFactor);
                green = (int) (((rgb >> 8) & 0x000000FF) * brightnessFactor);
                blue = (int) (((rgb) & 0x000000FF) * brightnessFactor);

                rgb = (red << 16) | (green << 8) | (blue);

                output.setRGB(i, j, rgb);

            }

        }
        return output;
    }

    public static double colorDistance(int r1, int g1, int b1, int r2, int g2, int b2) {

        return Math.sqrt(Math.pow((r2 - r1), 2) + Math.pow((g2 - g1), 2) + Math.pow((b2 - b1), 2));

    }

    public static BufferedImage gammaCorrection(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage output = new BufferedImage(width, height, image.getType());
        int rgb = 0;
        int red = 0, green = 0, blue = 0;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                rgb = image.getRGB(x, y);

                red = (int) (((rgb >> 16) & 0x000000FF));
                green = (int) (((rgb >> 8) & 0x000000FF));
                blue = (int) (((rgb) & 0x000000FF));

                red = (int) (255d * Math.pow((red / 255d), gammaCorrection));
                green = (int) (255d * Math.pow((green / 255d), gammaCorrection));
                blue = (int) (255d * Math.pow((blue / 255d), gammaCorrection));

//                System.out.println(tempRed);
                rgb = (red << 16) | (green << 8) | (blue);

                output.setRGB(x, y, rgb);

            }
        }

        return output;
    }
}
