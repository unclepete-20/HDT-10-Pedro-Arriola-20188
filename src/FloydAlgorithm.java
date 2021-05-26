/**
 * @author unclepete-20
 * Carnet 20188
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 * Hoja de trabajo 10
 * Código extraido de: https://www.sanfoundry.com/java-program-implement-floyd-warshall-algorithm/
 */

public class FloydAlgorithm {
    private int distancematrix[][];
    private int numberofvertices;
    public static final int INFINITY = 999;

    public FloydAlgorithm(int numberofvertices)
    {
        distancematrix = new int[numberofvertices + 1][numberofvertices + 1];
        this.numberofvertices = numberofvertices;
    }

    public void floydwarshall(int adjacencymatrix[][])
    {
        for (int source = 1; source <= numberofvertices; source++)
        {
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                distancematrix[source][destination] = adjacencymatrix[source][destination];
            }
        }

        for (int intermediate = 1; intermediate <= numberofvertices; intermediate++)
        {
            for (int source = 1; source <= numberofvertices; source++)
            {
                for (int destination = 1; destination <= numberofvertices; destination++)
                {
                    if (distancematrix[source][intermediate] + distancematrix[intermediate][destination]
                            < distancematrix[source][destination])
                        distancematrix[source][destination] = distancematrix[source][intermediate]
                                + distancematrix[intermediate][destination];
                }
            }
        }

        for (int source = 1; source <= numberofvertices; source++)
            System.out.print("\t" + source);

        System.out.println();
        for (int source = 1; source <= numberofvertices; source++)
        {
            System.out.print(source + "\t");
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                System.out.print(distancematrix[source][destination] + "\t");
            }
            System.out.println();
        }
    }
}
