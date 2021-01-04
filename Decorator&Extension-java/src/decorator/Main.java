package decorator;

public class Main {
    public static void main(String args[]) {
        String text = "Labas";

        ITextEditor textEditor = new HtmlEscaper(new Translator(new TextEditor()));

        System.out.println(textEditor.getName());
        System.out.println("Cost: " + textEditor.getCost(text.length()));

        Translator translator = (Translator) ((Decorator)textEditor).getRole(Translator.class);
        
        if (translator != null) {
            System.out.println("Translated text: " + translator.translate(text, "en", "lt"));
        } else {
            System.out.println("The editor does not have translator role.");
        }

        ITextEditor textEditor2 = new Translator(new TextEditor());
        System.out.println(textEditor2.getName());
        System.out.println("Cost: " + textEditor2.getCost(text.length()));
    }
}
