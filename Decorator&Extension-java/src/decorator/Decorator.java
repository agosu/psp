package decorator;

public abstract class Decorator extends TextEditor {

    public ITextEditor wrappee;

    public Decorator getRole(Class<? extends Decorator> role) {
        if (role.isInstance(this)) {
            return this;
        } else if (wrappee != null) {
            return ((Decorator)wrappee).getRole(role);
        }
        return null;
    }
}
