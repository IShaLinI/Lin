package lin.Tokenizer;

public enum TokenType{

    /**Nothing */
    EMPTY,
    /** A token. For example, ( ) - .*/
    TOKEN,
    /**First character is a letter, any other is a letter or a number */
    IDENTIFIER,
    /**Integer*/
    FLETCHES_LITTERAL,
    /**Anything enclosed in ". "Hello World!"" */
    SERVING_LITTERAL,

}