import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // Bước 1: Xử lý chuỗi đa thức
    public static List<Term> parsePolynomial(String polyStr) {
        List<Term> terms = new ArrayList<>();
        Pattern pattern = Pattern.compile("([-+]?(\\d*)x\\^(\\d+))");
        Matcher matcher = pattern.matcher(polyStr);

        while (matcher.find()) {
            int coeff = 1;
            if (!matcher.group(2).isEmpty()) {
                coeff = Integer.parseInt(matcher.group(2));
            }
            int power = Integer.parseInt(matcher.group(3));
            terms.add(new Term(coeff, power));
        }

        return terms;
    }
    // Bước 2: Đạo hàm đa thức
    public static List<Term> differentiatePolynomial(List<Term> polynomial) {
        List<Term> derivative = new ArrayList<>();
        for (Term term : polynomial) {
            int coeff = term.getCoefficient() * term.getPower();
            int power = term.getPower() - 1;
            if (power >= 0) {
                derivative.add(new Term(coeff, power));
            }
        }
        return derivative;
    }

    // Bước 3: Tính giá trị của đa thức khi biết x
    public static int evaluatePolynomial(List<Term> polynomial, int x) {
        int value = 0;
        for (Term term : polynomial) {
            value += term.getCoefficient() * Math.pow(x, term.getPower());
        }
        return value;
    }

    public static void main(String[] args) {
        // Đa thức đầu vào
        String inputPolynomial = "5x^3 - 6x^4 + 6x^9 + 7x + 2";

        // Bước 1: Xử lý chuỗi đa thức
        List<Term> polynomial = parsePolynomial(inputPolynomial);
        System.out.println("Da thuc: " + polynomial);

        // Bước 2: Đạo hàm đa thức
        List<Term> derivative = differentiatePolynomial(polynomial);
        System.out.println("Dao ham: " + derivative);

        // Bước 3: Tính giá trị của đa thức khi x = 2
        int xValue = 2;
        int result = evaluatePolynomial(polynomial, xValue);
        System.out.println("Gia tri cua da thuc khi x = " + xValue + ": " + result);
    }

}

