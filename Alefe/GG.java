//DUVIDAS//

//REMOVER UMA STRING DA LISTA QUE TA DENTRO DE UMA ARVORE;
class Alef{
public String metodoRemover(String chave){
    No1 no = pesquisar(chave , raiz);
    Celula i = no.primeiro;
    i = remover(chave, no.primeiro);
    String rem = removido(i);
    return rem;
}

public No1 pesquisar(char chave) {
        No1 no = raiz;
        while (no.primeiraLetra != chave) {
            if (chave < no.primeiraLetra) {
                no = no.esq;
            } else {
                no = no.dir;
            }
        }
        return no;
    }

    private Celula remover(String str, Celula i) {
        for (; i.value.prox.equals(str) == false ; i = i.prox );
        Celula tmp = i.prox;
        i.prox = tmp.prox;
        tmp.prox = null;
        return tmp;
    }

    private String removido(Celula i){
        return i.value;
    }


//REMOVER DE UMA ARV DE ARV

public void metodoRemover(String chave){
    No1 no = pesquisar(chave , raiz);
    no.outra = remover(chave, no.outra);
}

private No1 pesquisar(String str, No1 i) {
        char c = str.charAt(0);
        No1 no = raiz;
        while (no.primeiraLetra != chave) {
            if (chave < no.primeiraLetra) {
                no = no.esq;
            } else {
                no = no.dir;
            }
        }
        return no;
    }

    private No2 remover(String str, No2 i) {
        if (i == null) {
            Sout("erro");
        }
        else if(i.value.compareTo(str) < 0){
            i.esq = remover(str , i,esq);
        }
        else if(i.value.compareTo(str) > 0){
            i.dir = remover(str, i.dir);
        }
        else if(i.dir == null){
            i = i.esq;
        }
        else if(i.esq == null){
            i = i.dir;
        }
        else{
            i = anterior(i,i.esq);
        }
        return i;
    }

    private No2 anterior(No2 i, No2 j){
        if(j != null){
            j = anterior(i,j.dir);
        }
        else{
            i.value = j.value;
            j = j.esq;
        }
        return j;
    }
}
   