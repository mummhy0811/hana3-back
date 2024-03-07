public class ex06 {
    public static void main(String[] args) {
        //연습문제 DM제출
        String str5 = "java";
        String str6 = "Web Programming is funny~";
        String str7 = "  Test Trim String  ";
//1. "funny"의 시작 인덱스를 출력하시오.
        System.out.println(str6.lastIndexOf("funny"));
//2. str6를 모두 대문자로 출력하시오.
        System.out.println(str6.toUpperCase());
//3. str6를 모두 소문자로 ~
        System.out.println(str6.toLowerCase());
//4. str5와 str6을 concat함수로 연결하여 출력하시오.
        System.out.println(str5.concat(str6));
//5. str7의 시작과 끝 공백만 제거하여 출력하시오.
        System.out.println(str7.trim());
//6. str7의 모든 공백을 *로 치환하여 출력하시오.
        System.out.println(str7.replace(" ", "*"));
//7. str6은 "web"문자열을 포함하고 있는지? (대소문자 안가림)
        System.out.println(str6.toLowerCase().contains("web"));
//   true/false로 출력하시오.
//8. str6을 문자열 배열로 만들고, "Web"와 "funny~"만 출력하시오.
        String[] arr=str6.split(" ");
        System.out.println(arr[0] +" "+arr[3]);
    }
}
