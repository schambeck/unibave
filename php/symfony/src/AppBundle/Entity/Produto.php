<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping\Column;
use Doctrine\ORM\Mapping\Entity;
use Doctrine\ORM\Mapping\GeneratedValue;
use Doctrine\ORM\Mapping\Id;
use Doctrine\ORM\Mapping\Table;

/**
 * @Entity
 * @Table(name="produto")
 */
class Produto {

    /**
     * @Id
     * @GeneratedValue(strategy="AUTO")
     * @Column(type="integer", nullable=false)
     */
    protected $id;
    
    /**
     * @Column(type="string", length=50, nullable=false)
     */
    protected $nome;
    
    /**
     * @Column(type="decimal", scale=2)
     */
    protected $preco;
    
    /**
     * @Column(type="string", length=100, nullable=false)
     */
    protected $descricao;
    
    function getId() {
        return $this->id;
    }

    function getNome() {
        return $this->nome;
    }

    function getPreco() {
        return $this->preco;
    }

    function getDescricao() {
        return $this->descricao;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setNome($nome) {
        $this->nome = $nome;
    }

    function setPreco($preco) {
        $this->preco = $preco;
    }

    function setDescricao($descricao) {
        $this->descricao = $descricao;
    }

}
