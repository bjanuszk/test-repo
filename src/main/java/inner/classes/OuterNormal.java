package inner.classes;

public class OuterNormal {

    private static String staticText;
    private String nonstaticText = "outer non-static text";

    private static String getGetNonstaticText() {
        staticText = "non static text from static method";
        return OuterNormal.staticText;
    }

    public OuterNormal() {
        System.out.println("Outer constructor.");
    }

    public class InnerNormal {
        public InnerNormal() {
            System.out.println("Inner static constructor.");
        }

        public void printStaticText() {
            System.out.println(nonstaticText);
        }

        public void pringNonStaticText() {
            System.out.println(getGetNonstaticText());
        }
    }
}
