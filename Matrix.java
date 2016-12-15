public class Matrix
{
    public int[][] mat;
    
    public Matrix(int x, int y)
    {
        mat = new int[x][y];
    }
    
    public Matrix(int x)
    {
        mat = new int[x][x];
    }
    
    public String toString()
    {
        String temp = "";
        for(int a = 0; a < mat.length; a++)
        {
            temp += "[ ";
            for(int b = 0; b < mat[a].length; b++)
            {
                temp += mat[a][b] + "\t";
            }
            temp += "]\n";
        }
        return temp;
    }
}
