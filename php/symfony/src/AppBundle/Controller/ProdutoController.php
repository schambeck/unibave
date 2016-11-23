<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Produto;
use FOS\RestBundle\Controller\FOSRestController;
use FOS\RestBundle\View\View;
use FOS\RestBundle\Controller\Annotations\Get;
use FOS\RestBundle\Controller\Annotations\Post;
use FOS\RestBundle\Controller\Annotations\Put;
use FOS\RestBundle\Controller\Annotations\Delete;
use Symfony\Component\HttpFoundation\Response;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\ParamConverter;
use Symfony\Component\HttpKernel\Exception\NotFoundHttpException;

class ProdutoController extends FOSRestController {

    /**
     * @Get("/rest/produtos")
     */
    public function findAll() {
        $produtos = $this->getDoctrine()
                ->getRepository('AppBundle:Produto')
                ->findAll();
        
        return $produtos;
    }

    /**
     * @Get("/rest/produtos/{id}")
     */
    public function find($id) {
        $produto = $this->getDoctrine()
                ->getRepository('AppBundle:Produto')
                ->find($id);

        if (!$produto) {
            throw new NotFoundHttpException("Produto inexistente");
        }

        return $produto;
    }

    /**
     * @Post("/rest/produtos")
     * @ParamConverter("produto", converter="fos_rest.request_body")
     */
    public function create(Produto $produto) {
        $em = $this->getDoctrine()->getManager();
        $em->persist($produto);
        $em->flush(); // demarca transação
        return $produto;
    }
    
    /**
     * @Put("/rest/produtos/{id}")
     * @ParamConverter("produto", converter="fos_rest.request_body")
     */
    public function update($id, Produto $produto) {
        $em = $this->getDoctrine()->getManager();
        $produto_ = $em->getRepository('AppBundle:Produto')->find($id);
        if (!$produto_) {
            throw new NotFoundHttpException("Produto inexistente");
        }

        $em->merge($produto);
        $em->flush();

        return $produto;
    }

    /**
     * @Delete("/rest/produtos/{id}")
     */
    public function remove($id) {
        $em = $this->getDoctrine()->getManager();
        $produto = $em->getRepository('AppBundle:Produto')->find($id);
        if (!$produto) {
            throw new NotFoundHttpException("Produto inexistente");
        }

        $em->remove($produto);
        $em->flush();

        return new Response("Produto excluído", Response::HTTP_NO_CONTENT);
    }

}
