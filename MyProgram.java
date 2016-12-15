public class MyProgram extends ConsoleProgram
{
    public void run()
    {
        Matrix m1;
        repeater: while(true)
        {
            switch(readInt("What are you doing?\n1. Operation between two Matricies\n2. Multiplying into a matrix\n3. Determinant\n4. Quit\n"))
            {
                case 1:
                    println("\nSetup first matrix: ");
                    m1 = new Matrix(readInt("X length? "), readInt("Y length? "));
                    buildMatrix(m1);
                    
                    println("\nSetup second matrix: ");
                    Matrix m2 = new Matrix(readInt("X length? "), readInt("Y length? "));
                    buildMatrix(m2);
                    
                    process(m1, m2);
                    break;
                case 2:
                    println("\nSetup matrix: ");
                    m1 = new Matrix(readInt("X length? "), readInt("Y length? "));
                    buildMatrix(m1);
                    
                    multInto(m1, readInt("What are you multiplying into this? "));
                    break;
                case 3:
                    println("\nSetup matrix: ");
                    m1 = new Matrix(readInt("X&Y length? "));
                    buildMatrix(m1);
                    
                    determinate(m1);
                    break;
                case 4:
                    println("\nAlright, we're done then");
                    break repeater;
                default:
                    println("An error has been encountered, likely an index out of bounds.");
            }
        }
    }
    
    public void buildMatrix(Matrix m)
    {
        for(int a = 0; a < m.mat.length; a++)
        {
            for(int b = 0; b < m.mat[a].length; b++)
            {
                println("\n" + m);
                m.mat[a][b] = readInt("Value of (" + (a + 1) + "/" + (b + 1) + ")? ");
            }
        }
        println("\n" + m);
    }
    
    public void process(Matrix m1, Matrix m2)
    {
        repeater: while(true)
        {
            switch(readInt("What do you want to do with these?\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Quit\n"))
            {
                case 1:
                    println(add(m1, m2));
                    break;
                case 2:
                    println(subtract(m1, m2));
                    break;
                case 3:
                    println(multiply(m1, m2));
                    break;
                case 4:
                    println(divide(m1, m2));
                    break;
                case 5:
                    println("\nAlright, we're done then");
                    break repeater;
                default:
                    System.out.println("An error has occured, the selected opperand is likely not an option.");
            }
        }
    }
    
    public String add(Matrix m1, Matrix m2)
    {
        int[][] mat1 = m1.mat;
        int[][] mat2 = m2.mat;
        Matrix m3;
        if(mat1.length == mat2.length && mat1[0].length == mat2[0].length)
        {
            m3 = new Matrix(mat1.length, mat2[0].length);
            for(int a = 0; a < mat1.length; a++)
            {
                for(int b = 0; b < mat2.length; b++)
                {
                    m3.mat[a][b] = mat1[a][b] + mat2[a][b];
                }
            }
            return "\n" + m3.toString();
        }
        else
        {
            return "Can't be done with these dimensions";
        }
    }
    
    public String subtract(Matrix m1, Matrix m2)
    {
        int[][] mat1 = m1.mat;
        int[][] mat2 = m2.mat;
        Matrix m3;
        if(mat1.length == mat2.length && mat1[0].length == mat2[0].length)
        {
            m3 = new Matrix(mat1.length, mat2[0].length);
            for(int a = 0; a < mat1.length; a++)
            {
                for(int b = 0; b < mat2.length; b++)
                {
                    m3.mat[a][b] = mat1[a][b] - mat2[a][b];
                }
            }
            return "\n" + m3.toString();
        }
        else
        {
            return "Can't be done with these dimensions";
        }
    }
    
    public String multiply(Matrix m1, Matrix m2)
    {
        int[][] mat1 = m1.mat;
        int[][] mat2 = m2.mat;
        Matrix m3;
        if(mat1[0].length == mat2.length)
        {
            m3 = new Matrix(mat1.length, mat2[0].length);
            for(int a = 0; a < m3.mat.length; a++)
            {
                for(int b = 0; b < m3.mat[a].length; b++)
                {
                    for(int c = 0; c < mat1[0].length; c++)
                    {
                        m3.mat[a][b] += mat1[a][c] * mat2[c][a];
                    }
                }
            }
            return "\n" + m3.toString();
        }
        else
        {
            return "Can't be done with these dimensions";
        }
    }
    
    public String divide(Matrix m1, Matrix m2)
    {
        return "\n**Not implemented.**\n";
    }
    
    public void multInto(Matrix m, int mult)
    {
        Matrix newMat = new Matrix(m.mat.length, m.mat[0].length);
        for(int a = 0; a < m.mat.length; a++)
        {
            for(int b = 0; b < m.mat[a].length; b++)
            {
                newMat.mat[a][b] = m.mat[a][b] * mult;
            }
        }
        println("\n" + newMat);
    }
    
    public void determinate(Matrix m)
    {
        if(m.mat.length == 2)
        {
            println("Your determinant: " + ((m.mat[0][0] * m.mat[1][1]) - (m.mat[1][0] * m.mat[0][1])));
        }
        else if(m.mat.length == 3)
        {
            Matrix tM = new Matrix(3, 5);
            for(int a = 0; a < m.mat.length; a++)
            {
                for(int b = 0; b < m.mat[a].length; b++)
                {
                    tM.mat[a][b] = m.mat[a][b];
                }
            }
            for(int a = 0; a < 3; a++)
            {
                for(int b = 0; b < 2; b++)
                {
                    tM.mat[a][b + 3] = m.mat[a][b];
                }
            }
            println(tM);
            int first = 0;
            int second = 0;
            for(int b = 0; b < 3; b++)
            {
                first += tM.mat[0][b] * tM.mat[1][b + 1] * tM.mat[2][b + 2];
            }
            for(int b = 0; b < 3; b++)
            {
                second += tM.mat[2][b] * tM.mat[1][b + 1] * tM.mat[0][b + 2];
            }
            println("Your determinant: " + (first - second));
        }
        else
        {
            println("Can't use that size");
        }
    }
}
