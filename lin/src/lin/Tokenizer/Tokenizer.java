package lin.Tokenizer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private ArrayList<TokenData> tokenDatas;

    private String str;

    private Token lastToken;
    private boolean pushBack;

    public Tokenizer(String str){

        this.tokenDatas = new ArrayList<TokenData>();
        this.str = str;

        tokenDatas.add(new TokenData(Pattern.compile("^([a-zA-Z][a-zA-Z0-9]*)"),TokenType.IDENTIFIER));
        tokenDatas.add(new TokenData(Pattern.compile("^((-)?[0-9]+)"),TokenType.FLETCHES_LITTERAL));
        tokenDatas.add(new TokenData(Pattern.compile("^(\".*\")"), TokenType.SERVING_LITTERAL));

        for (String t : new String[] { "=", "\\(",  "\\)", "\\.", "\\,"}) {tokenDatas.add(new TokenData(Pattern.compile(t), TokenType.TOKEN));}

    }
    
    public Token nextToken(){

        str = str.trim();

        if(pushBack){

            pushBack = false;
            return lastToken;

        }

        if(str.isEmpty()){return(lastToken = new Token("", TokenType.EMPTY));}

        for (TokenData data : tokenDatas){

            Matcher matcher = data.getPattern().matcher(str);

            if(matcher.find()){

                String token = matcher.group().trim();
                str = matcher.replaceFirst("");

                if(data.getType() == TokenType.SERVING_LITTERAL){return(lastToken = new Token(token.substring(1, token.length() -1), TokenType.SERVING_LITTERAL));}
                else{return (lastToken = new Token(token, data.getType()));}
            }
        }
        throw new IllegalStateException("No Parse gonna happen: " + str);
    }

    public boolean hasNextToken(){return !str.isEmpty();}
    public void pushBack(){if(lastToken != null){this.pushBack = true;}}
}