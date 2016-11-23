<?php

namespace AppBundle\Controller;

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class DefaultController extends Controller {

    /**
     * @Route("/", name="homepage")
     */
    public function indexAction(Request $request) {
        // replace this example code with whatever you need
        return $this->render('default/index.html.twig', [
                    'base_dir' => realpath($this->getParameter('kernel.root_dir') . '/..') . DIRECTORY_SEPARATOR,
        ]);
    }

    /**
     * @Route("/produto.css")
     */
    public function cssAction(Request $request) {
        $response = new Response;
        $response->headers->set('Content-Type', 'text/css');
        return $this->render('css/produto.css', [], $response);
    }

    /**
     * @Route("/produto.js")
     */
    public function jsAction(Request $request) {
        return $this->render('js/produto.js');
    }

}
