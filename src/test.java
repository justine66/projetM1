public class test {

    public static void main(String[] args) {
        ARN arn1 = new ARN("AAUU", "(())");
        ARN arn2 = new ARN("AAAU", "(--)");
        ARN arn3 = new ARN("AAAU", "-(-)");




        /* test de la methode is_appiered(a)*/
        System.out.println(arn1.is_appiered(arn2.getAppariement()));
        System.out.println(arn1.is_appiered(arn1.getAppariement()));

        /* test de la methode is_appiered(a, s)*/
        System.out.println(arn1.is_appiered(arn2.getAppariement(), arn2.getSequence()));
        System.out.println(arn1.is_appiered(arn1.getAppariement(), arn1.getSequence()));

    }
}
