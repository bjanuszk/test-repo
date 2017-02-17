package inner.classes;

public class OuterStatic {

    private static String staticText = "outer static text";

    private static String getGetNonstaticText() {
        return "non static text from static method";
    }

    public OuterStatic() {
        System.out.println("Outer constructor.");
    }

    public static class InnerStatic {
        public InnerStatic() {
            System.out.println("Inner static constructor.");
        }

        public void printStaticText() {
            System.out.println(staticText);
        }

        public void pringNonStaticText() {
            System.out.println(getGetNonstaticText());
        }
    }
}
