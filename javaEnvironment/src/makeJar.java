public class makeJar {
    public static void main(String[] args) {
        //Answer's Box
        String[] answers = { "고영우","김백규","김아영","김정률","김지윤",
                "김현우","도승희","문서연","문혜영","박효리",
                "백건우","변지혜","신명지","안나영","이민지",
                "이서하","이신광","이은수","이채원","임유빈",
                "임혜진","정건우","정연주","정재건","최은진","최지웅" };

        int index = (int)(Math.random() * answers.length);

        System.out.println( "대답하실 분은 : " + answers[index] );
    }
}
