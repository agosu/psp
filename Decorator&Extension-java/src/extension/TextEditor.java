package extension;

import java.util.ArrayList;
import java.util.List;

public class TextEditor {

    private List<Extension> extensions = new ArrayList<>();

    public void addExtension(Extension extension) {
        if (extensions.size() > 0) {
            extensions.get(extensions.size() - 1).setNext(extension);
        }
        extensions.add(extension);
    }

    public void removeExtension(Extension extension) {
        extensions.remove(extension);
    }

    public Extension getExtension(Class<? extends Extension> extension) {
        for (Extension e : extensions) {
            if (extension.equals(e.getClass())) {
                return e;
            }
        }
        return null;
    }

    public String fixErrors(String text) {
        return text + " {errors fixed}";
    }

    public double getCost(int textLength) {
        if (extensions != null) {
            return 0.25 * textLength + extensions.get(0).getCost(textLength);
        }
        return 0.25 * textLength;
    }

    public String getName() {
        if (extensions != null) {
            return "TextEditor" + extensions.get(0).getName();
        }
        return "TextEditor";
    }
}
