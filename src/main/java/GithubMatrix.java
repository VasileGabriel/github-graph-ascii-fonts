/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class GithubMatrix {

    public static void main(String[] args) {
	System.out.println("merge");
        Comitter co = new Comitter();
        String text = new StringBuffer("Dada").reverse().toString();
        co.processPhrase(text);
    }
}
