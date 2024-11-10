public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		// verifica se o texto recebido � nulo ou ent�o vazio,
		// ou seja, sem nenhum caractere, lan�ando exce��o.
		// armazena o texto recebido em this.texto.
        if (texto == null || texto == "") {
            throw new Exception("Texto inválido!");
        }
        this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        // percorre o String this.texto, conta e retorna
        // quantas letras existem nele iguais a letra fornecida
        int contador = 0;
        for(int i = 0; i < this.texto.length(); i++) {
            if (this.texto.charAt(i) == letra)
                contador++;
        }
        return contador;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        // se i==0, retorna a posicao em que ocorre a primeira
        // aparicao de letra fornecida em this.texto;
        // se i==1, retorna a posicao em que ocorre a segunda
        // aparicao de letra fornecida em this.texto;
        // se i==2, retorna a posicao em que ocorre a terceira
        // aparicao de letra fornecida em this.texto;
        // e assim por diante.
        // lan�ar excecao caso nao encontre em this.texto
        // a I�zima apari��o da letra fornecida.
        int qtdOcorrencias = getQuantidade(letra);
        if (qtdOcorrencias == 0 || qtdOcorrencias < i) throw new Exception("Não há ocorrências da letra " + letra + " na palavra " + this.texto);
        int pos = -1;
        for(int j = 0; j < this.texto.length(); j++) {
            if (this.texto.charAt(j) == letra) {
                pos++;
                if (pos == i) {
                    return j;
                }
            } 
        }
        return -1; //nunca vai chegar aqui               
    }
                                                                                                                                                 
    public int getTamanho ()
    {
        return this.texto.length();
    }

    public String toString ()
    {
        return this.texto;
    }

    public boolean equals (Object obj)
    {
        if (obj == null) return false;

        if (obj == this) return true; //mesmo endereço

        if (obj.getClass() != this.getClass()) return false;

        Palavra word = (Palavra)obj;

        return this.texto == word.texto;
        
        //return (this.equals(obj));
        
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo

    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int ret = 666;

        ret = 13*ret + new String(this.texto).hashCode();

        if(ret<0) ret = -ret;

        return ret;
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
