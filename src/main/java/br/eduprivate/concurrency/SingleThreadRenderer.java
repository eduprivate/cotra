package br.eduprivate.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * SingleThreadRendere
 * <p/>
 * Rendering page elements sequentially
 *
 */
public abstract class SingleThreadRenderer {
    void renderPage(CharSequence source) {
        renderText(source);
        List<ImageData> imageData = new ArrayList<ImageData>();
        for (ImageInfo imageInfo : scanForImageInfo(source))
            imageData.add(imageInfo.downloadImage());
        for (ImageData data : imageData)
            renderImage(data);
    }

    interface ImageData {
    }

    interface ImageInfo {
        ImageData downloadImage();
    }

    abstract void renderText(CharSequence s);
    abstract List<ImageInfo> scanForImageInfo(CharSequence s);
    abstract void renderImage(ImageData i);
}
