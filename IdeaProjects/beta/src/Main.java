public class Main {
    public static void main(String[] args) {
        int grade1 = 82;
        int grade2 = 96;
        int grade3 = 88;
        double avgGrade = (grade1 + grade2 + grade3);
        avgGrade = avgGrade/3;
        System.out.println(avgGrade);
        double variance =((Math.pow((grade1-avgGrade), 2)) + (Math.pow((grade2-avgGrade), 2)) +
                (Math.pow((grade3-avgGrade), 2)))/3;
        double stanDeviation =(Math.sqrt(variance));
        System.out.println(variance);
        System.out.println(stanDeviation);

    }
}