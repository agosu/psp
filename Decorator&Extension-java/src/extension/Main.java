package extension;

public class Main {
    public static void main(String args[]) {
        String text = "Labas";

        TextEditor textEditor = new TextEditor();
        textEditor.addExtension(new Translator());
        textEditor.addExtension(new HtmlEscaper());
        textEditor.addExtension(new AgeCensor());

        System.out.println(textEditor.getName());
        System.out.println("Cost: " + textEditor.getCost(text.length()));

        Translator translator = (Translator)textEditor.getExtension(Translator.class);
        HtmlEscaper htmlEscaper = (HtmlEscaper) textEditor.getExtension(HtmlEscaper.class);
        AgeCensor ageCensor = (AgeCensor) textEditor.getExtension(AgeCensor.class);

        if (translator != null) {
            System.out.println("Translated text: " + translator.translate(text, "en", "lt"));
        } else {
            System.out.println("The editor does not have translator role.");
        }
        if (htmlEscaper != null) {
            System.out.println("Html escaped text: " + htmlEscaper.escapeHtml(text));
        } else {
            System.out.println("The editor does not have html escaper role.");
        }
        if (ageCensor != null) {
            System.out.println("Age censored text: " + ageCensor.censor(text, 3));
        } else {
            System.out.println("The editor does not have age censor role.");
        }

        TextEditor textEditor2 = new TextEditor();
        textEditor2.addExtension(new Translator());
        System.out.println(textEditor2.getName());
        System.out.println("Cost: " + textEditor2.getCost(text.length()));
    }
}
