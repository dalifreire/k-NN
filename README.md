
[![Build Status](https://travis-ci.org/dalifreire/k-NN.svg?branch=master)](https://travis-ci.org/dalifreire/k-NN)

# k-NN

O k-NN (do inglês: k Nearest Neighboors), é um algoritmo utilizado para resolver problemas de classificação. A idéia principal do k-NN é determinar a classe de uma determinada amostra baseado nas suas amostras vizinhas mais próximas. Na figura abaixo, temos um a ilustração do funcionamento do k-NN, onde deseja-se determinar a classe de uma amostra representada por um 'círculo verde'.

![k-nn](https://user-images.githubusercontent.com/10319140/38783722-66332bde-40dc-11e8-85ca-b88b8f5d93ef.png)


# Execução

Um executável do algoritmo foi disponibilizado na pasta [dist](https://github.com/dalifreire/k-NN/tree/master/dist). Para executar a aplicação, basta realizar o download do arquivo [k-NN.jar](https://github.com/dalifreire/k-NN/tree/master/dist/k-NN.jar) e executá-lo:
```sh
java -jar k-NN.jar
```

![Tela](https://user-images.githubusercontent.com/10319140/38783580-4f1a7fbc-40da-11e8-821e-ea105779b518.png)


Caso prefira, também é possível clonar o repositório e realizar a execução direta do fonte.. a classe main para a execução da aplicação é a seguinte:


[br.com.ufu.pgc204.knn.controller.FrameController](https://github.com/dalifreire/k-NN/blob/master/knn/src/main/java/br/com/ufu/pgc204/knn/controller/FrameController.java)