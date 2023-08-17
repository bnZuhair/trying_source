class ValidationException extends Exception
{
	public ValidationException() {
		super("the value entered is not valid");
	}
	
	public ValidationException(String message)
	{
		super(message);
	}
	
	public ValidationException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public ValidationException (Throwable cause)
	{
		super(cause);
	}
}

class Phone
{
	String name, serialNumber;
	
	public Phone() throws ValidationException
	{
		throw new ValidationException("you must enter valid name and serial number for the phone");
	}
	
	public Phone(String nameOrNumber) throws ValidationException
	{
		throw new ValidationException("you must enter both the name and serial number");
	}
	
	public Phone(String name, String serialNumber) throws Exception
	{
		if(serialNumber.length() != 16) 
		{
			throw new ValidationException("you must enter valid serial number for the phone");
		}
	}
}
public class Test
{
	public static void main(String[] args) 
	{
		
		try 
		{
			Phone num1 = new Phone("iPhone", "1234567890123456"); 
			System.out.println("yay you did it");
		} 
		catch ( ValidationException e) 
		{
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}