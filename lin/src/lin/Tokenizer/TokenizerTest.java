package lin.Tokenizer;

public class TokenizerTest{

    public static void main(String[] args){

        String code  = "bow HelloWorld\n" +
                        "sling main requires()\n" +
                         "loose \"Hello\""
        ;

        Tokenizer tokenizer = new Tokenizer(code);

        while (tokenizer.hasNextToken()){

            System.out.println(tokenizer.nextToken().getToken());

        }
    }
}