package bsu.rfe.java.group5.lab3.Borovik.varB2;

import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {

	private Double[] coefficients;
	private Double from;
	private Double to;
	private Double step;
	public GornerTableModel(Double from, Double to, Double step,
			Double[] coefficients) {
			this.from = from;
			this.to = to;
			this.step = step;
			this.coefficients = coefficients;
			}
			public Double getFrom() {
			return from;
			}
			public Double getTo() {
			return to;
			}
			public Double getStep() {
			return step;
			}
			public int getColumnCount() {
			// В данной модели два столбца
			return 3;
			}
			public int getRowCount() {
			// Вычислить количество точек между началом и концом отрезка
			// исходя из шага табулирования
			return new Double(Math.ceil((to-from)/step)).intValue()+1;
			}
			 public static String reverseString(String str) {
			        return new StringBuilder(str).reverse().toString();
			    }
			public Object getValueAt(int row, int col) {
			// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
			double x = from + step*row;
			if (col==0) {
			// Если запрашивается значение 1-го столбца, то это X
			return x;
			} else {if(col == 1) {
			// Если запрашивается значение 2-го столбца, то это значение
			// многочлена
				return calculateGornerValue(x);}
			else {
				Double integ = calculateGornerValue(x) ;
				double number = integ;
				Integer integerPart = (int) number;
                int integerLenght = 1;
                while ((int) (integerPart / Math.pow(10, integerLenght)) != 0) integerLenght++;
                int p = (int) Math.pow(10,integerLenght);
                integ=Math.ceil(integ*p)/p;
            String str =integ.toString();
            boolean flag = true;
            for (int i = 0; i < coefficients.length/2; i++){
            	
                if (!str.equals(reverseString(str))){
                    flag = false;}
			
			         }
            return flag;
            }
			 
			}
			}
			public String getColumnName(int col) {
			switch (col) {
			case 0:
			// Название 1-го столбца
			return "Значение X";
			case 1:
			// Название 2-го столбца
			return "Значение многочлена";
			 default:
                return "Ограниченная симметрия";}
			
			}
			public Class<?> getColumnClass(int col) {
			// И в 1-ом и во 2-ом столбце находятся значения типа Double
				if(col==0||col==1) {
			return Double.class;}
				else 
				{ return Boolean.class;}
			}
			private Double calculateGornerValue(double x) {
		        double result = 0.0;
		        for (int i = coefficients.length - 1; i >= 0; i--)
		            result = result * x + coefficients[i];

		        return result;
		    }
			}
	/*public Double getCoefficient(int index) {
        return coefficients[index];
    }
	public GornerTableModel(Double from, Double to, Double step,
			Double[] coefficients) {
			this.from = from;
			this.to = to;
			this.step = step;
			this.coefficients = coefficients;
			}
	public Double getFrom() {
		return from;
		}
		public Double getTo() {
		return to;
		}
		public Double getStep() {
		return step;
		}

	public int getRowCount() {
		
		return new Double(Math.ceil((to-from)/step)).intValue()+1;
		
	}

	@Override
	public int getColumnCount() {
		// TODO Автоматически созданная заглушка метода
		return 3;
	}

	@Override
	public Object getValueAt(int row, int col) {

		
		// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
		double x = from + step*row;
		if (col==0) {
		// Если запрашивается значение 1-го столбца, то это X
		return x;
		} else {if(col==1) {
			Double result = 0.0;
			for (int i = 1; i < coefficients.length; i++) {
	            result = result * x + coefficients[i]; // Применяем схему Горнера
	        }
			// Вычисление значения в точке по схеме Горнера.
			return result;
		}
		/*else {
			 Double integ = result;
	            String str = integ.toString();
	            boolean flag = true;
	            for (int i = 0; i < coefficients.length/2; i++){
	                if (!str.equals(reverseString(str))){
	                    flag = false;		
		              }
		}
	   return flag;
		}
	    return 0;
		}
	
		
		
	
	public String getColumnName(int col) {
		switch (col) {
		case 0:
		// Название 1-го столбца
		return "Значение X";
		case 1 :
		// Название 2-го столбца
		return "Значение многочлена";
		 default:
			// Название 3-го столбца
             return "Палиндром?";
////           default:
 //            System.err.println("Too many columns");
   //          return null;
     }
		}
		
	public Class<?> getColumnClass(int col) {
		if (col != 0 || col != 1) {
            return Boolean.class;
        }
		// И в 1-ом и во 2-ом столбце находятся значения типа Double
		return Double.class;
		}
	 public static String reverseString(String str) {
	        return new StringBuilder(str).reverse().toString();
	    }
*/


