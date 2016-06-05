package net.unibave.showcase.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "carro")
@SequenceGenerator(name = "carro_seq", sequenceName = "carro_seq")
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="carro_seq")
    @Column(name = "cod_carro")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "cod_categoria")
    private Categoria categoria;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "url_foto")
    private String urlFoto;

    @Column(name = "url_info")
    private String urlInfo;
    
    @Column(name = "url_video")
    private String urlVideo;

    public Carro() {
    }

    public Carro(String nome, String descricao, String urlFoto, String urlInfo, String urlVideo) {
        this.nome = nome;
        this.descricao = descricao;
        this.urlFoto = urlFoto;
        this.urlInfo = urlInfo;
        this.urlVideo = urlVideo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlInfo() {
        return urlInfo;
    }

    public void setUrlInfo(String urlInfo) {
        this.urlInfo = urlInfo;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carro{" + "nome=" + nome + ", descricao=" + descricao + ", urlFoto=" + urlFoto + ", urlInfo=" + urlInfo + ", urlVideo=" + urlVideo + '}';
    }
    
    public static class Builder {
        
        private final Carro carro = new Carro();
        
        public Builder setNome(String nome) {
            carro.setNome(nome);
            return this;
        }
                
        public Builder setCategoria(Categoria categoria) {
            carro.setCategoria(categoria);
            return this;
        }
                
        public Builder setDescricao(String descricao) {
            carro.setDescricao(descricao);
            return this;
        }
                
        public Builder setUrlFoto(String urlFoto) {
            carro.setUrlFoto(urlFoto);
            return this;
        }
                
        public Builder setUrlInfo(String urlInfo) {
            carro.setUrlInfo(urlInfo);
            return this;
        }
        
        public Builder setUrlVideo(String urlVideo) {
            carro.setUrlVideo(urlVideo);
            return this;
        }
        
        public Carro create() {
            return carro;
        }
        
    }

    public static List<Carro> getCarros() {
        return Arrays.asList(new Carro[] {
            new Builder()
                .setNome("Tucker 1948")
                .setDescricao("O Tucker foi realmente uma inovação no mundo do design automóvel, e embora o modelo 1948 foi o único modelo já produzido seu efeito sobre o mundo dos automóveis ainda pode ser sentida até hoje. Preston Tucker e Alex Tremulis projetou o Tucker como uma tentativa de entrar na indústria automotiva, e apesar de apenas um punhado de carros foram produzidos os recursos que estavam presentes naqueles carros eram extremamente inovador para a época.")
                .setUrlFoto("http://www.livroandroid.com.br/livro/carros/classicos/Tucker.png")
                .setUrlInfo("http://hotrodekustom.blogspot.com/2011/04/tucker-torpedo-1948-bi-turbo-estilo.html")
                .setUrlVideo("http://www.livroiphone.com.br/carros/classicos/tucker.mp4")
                .create(),
            new Builder()
                .setNome("Chevrolet Corvette")
                .setDescricao("O Chevrolet corvette é também um clássico antigo, encontrado nos salões automobilísticos internacionais, ele foi o primeiro carro produzido inteiramente dos Estados Unidos. O modelo de 1958, pertencente a primeira geração do corvette é um dos mais conhecidos e era uma potência na época em que foi criado. Esse carro clássico chegava a 170 km/h e era bem leve, o que estava se tornando tendência quando ele começou a ser fabricado em 1953.")
                .setUrlFoto("http://www.livroandroid.com.br/livro/carros/classicos/Chevrolet_Corvette.png")
                .setUrlInfo("http://www.chevrolet.com/corvette-sports-cars")
                .setUrlVideo("http://www.livroiphone.com.br/carros/classicos/corvette.mp4")
                .create(),
            new Builder()
                .setNome("Chevrolet Impala Coupe")
                .setDescricao("O Impala foi lançado em 1958, como a configuração de acabamento Top de linha da Chevrolet, rebaixando o acabamento Bel Air a posição intermediária de acabamento. O Belair, por sua vez, era o nome da versão Hard Top Coupe (falso conversível) dos Chevrolets fabricados de 1950 até 1952. Em 1953, tornou-se o nome da versão de acabamento Top de Linha da Chevrolet, que ainda contava com o 1-50 e o 2-10, respectivamente, a entrada e intermediária.")
                .setUrlFoto("http://www.livroandroid.com.br/livro/carros/classicos/Chevrolet_Impala_Coupe.png")
                .setUrlInfo("http://en.wikipedia.org/wiki/Chevrolet_Impala")
                .setUrlVideo("http://www.livroiphone.com.br/carros/classicos/chevrolet_impala.mp4")
                .create(),
            new Builder()
                .setNome("Cadillac Deville Convertible")
                .setDescricao("O Cadillac 1968 conversível é terminado em suas desejaveis cores originais de San Mateo metálico vermelho e interior de couro branco. O acabamento é a modelo antigo e livre de imperfeições, pois passa por uma inspeção minuciosa. Dentro os modelos de Cadillac, o 1968 apresentou exterior modesto redesign, juntamente com linhas clássicas do Cadillac.")
                .setUrlFoto("http://www.livroandroid.com.br/livro/carros/classicos/Cadillac_Deville_Convertible.png")
                .setUrlInfo("http://en.wikipedia.org/wiki/Cadillac_Coupe_de_Ville")
                .setUrlVideo("http://www.livroiphone.com.br/carros/classicos/cadillac_deville.mp4")
                .create(),
            new Builder()
                .setNome("Chevrolet Bel-Air")
                .setDescricao("Este Chevrolet 1955 apresenta o melhor em design e execução. Mais de 92.000 dólares foi investido nessa máquina de alta qualidade, transformando-o no que se vê hoje, não incluindo o trabalho meticuloso. Este é um carro que lida e passeios de cada bocado tão bom quanto ele looks. Vem junto como cortesia um Gen IV Chevrolet 620 cavalos de potência, 496 cid Motor de Corrida de algodão acoplado a uma Engenharia Keisler Tremec TKO600 5-velocidade transmissão manual.")
                .setUrlFoto("http://www.livroandroid.com.br/livro/carros/classicos/Chevrolet_BelAir.png")
                .setUrlInfo("http://pt.wikipedia.org/wiki/Chevrolet_Bel_Air")
                .setUrlVideo("http://www.livroiphone.com.br/carros/classicos/chevrolet_bel_air.mp4")
                .create(),
            new Builder()
                .setNome("Cadillac Eldorado")
                .setDescricao("O original Cadillac Eldorado foi construído para um show de carro e foi mostrado para marcar o aniversário da Cadillac. A primeira vez que o nome foi usado Eldorado foi para uma edição limitada conversível em 1953. O Eldorado não estava no topo da linha, mas era sempre entre os mais caros e luxuosos veículos da Cadillac.")
                .setUrlFoto("http://www.livroandroid.com.br/livro/carros/classicos/Cadillac_Eldorado.png")
                .setUrlInfo("http://www.carmovies.com.br/2011/05/31/cadillac-eldorado-seville-1958")
                .setUrlVideo("http://www.livroiphone.com.br/carros/classicos/cadillac_eldorado.mp4")
                .create(),
            new Builder()
                .setNome("Ferrari 250 GTO")
                .setDescricao("A Ferrari 250 GTO é um automóvel que foi produzido pela Ferrari 1962-1964 especificamente para a corrida em 3 da FIA Grand Touring categoria Grupo de carro. Em 2004, o Sports Car International colocou o 250 GTO oitavo na lista dos Top Sports Cars dos anos 1960, e nomeou-o o carro desportivo de todos os tempos. Da mesma forma, a revista Motor Trend Classic colocou o 250 GTO em primeiro lugar uma lista dos, Greatest Ferraris de todos os tempos. Outros carros foram vendidos por quantias absurdas no passado, mas nenhum modelo chegou perto do valor pago por essa Ferrari.")
                .setUrlFoto("http://www.livroandroid.com.br/livro/carros/classicos/Ferrari_250_GTO.png")
                .setUrlInfo("http://pt.wikipedia.org/wiki/Ferrari_250_GTO")
                .setUrlVideo("http://www.livroiphone.com.br/carros/classicos/ferrari_gto.mp4")
                .create(),
            new Builder()
                .setNome("Dodge Challenger")
                .setDescricao("O Challenger é um modelo desportivo de duas portas de tamanho médio da Dodge. A sua produção iniciou-se em 1970. Partilhando a sua plataforma (E-Body) com o Plymouth Barracuda o Dodge Challenger impressionou pela sua vasta gama de motorizaçÃµes. Em 2006 a Dodge construiu um carro conceito denominado challenger Concept, que trouxe de volta o Challenger equipado de um motor Hemi V8 de 425cv. Sucesso de vendas nos Estados Unidos. O carro é importado também ao Brasil.")
                .setUrlFoto("http://www.livroandroid.com.br/livro/carros/classicos/Dodge_Challenger.png")
                .setUrlInfo("http://www.dodge.com/en/2011/challenger/index.html")
                .setUrlVideo("http://www.livroiphone.com.br/carros/classicos/dodge_challenger.mp4")
                .create(),
            new Builder()
                .setNome("Camaro SS 1969")
                .setDescricao("Ele talvez não tenha sido o mais veloz dos muscle cars, mas com o estilo específico desse ano-modelo e uma combinação única de opções de freios, motor, escapamento e alimentação, o Chevrolet Camaro Z28 1969 pode ser considerado como o mais desejável dos Z28. A dirigibilidade era excelente, com o auxílio de uma direção hidráulica tão rápida quanto firme na estrada. O Z28 1969 era um dos carros de aparência mais feroz na era clássica dos esportivos de alta potência e demonstrava o que os estilistas da Chevrolet eram capazes de criar a fim de expressar desempenho e emoção.")
                .setUrlFoto("http://www.livroandroid.com.br/livro/carros/classicos/Camaro_SS.png")
                .setUrlInfo("http://www.chevroletcamaro.com.br/index.shtml?s_icid=Institucional_Carhome_Camaro_Home#/geracoes")
                .setUrlVideo("http://www.livroiphone.com.br/carros/classicos/camaro_ss.mp4")
                .create(),
            new Builder()
                .setNome("Ford Mustang 1976")
                .setDescricao(" Ford Mustang é um automóvel esportivo produzido pela Ford Motor Company. Inicialmente, era uma variante do Ford Falcon. O carro começou a ser produzido em Dearborn, Michigan no começo de 1964 e apresentado ao público em 17 de abril de 1964 durante a New York Worlds Fair. O Mustang, apesar de ter sofrido grandes alterações ao longo dos anos é a mais antiga linha de automóvel da Ford. O nome Mustang é inspirado no caça da II Guerra Mundial, P-51 Mustang. O Mustang possui muitas versões especiais limitadas. Na verdade, foram criadas mais versÃµes limitadas do que versÃµes de produção em série.")
                .setUrlFoto("http://www.livroandroid.com.br/livro/carros/classicos/Ford_Mustang.png")
                .setUrlInfo("http://auto.howstuffworks.com/1974-1975-1976-1977-1978-ford-mustang7.htm")
                .setUrlVideo("http://www.livroiphone.com.br/carros/classicos/ford_mustang.mp4")
                .create(),
        });
    }

}
