<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Investment</h1>
<form action="addInvestment" method="post">
Enter Plan Name<input type="text" name="planName"><br>
Entry_Age<input type="text" name="entryAge"><br>
Amount<input type="text" name="amount"><br>
Term<input type="text" name="term"><br>
Risk<input type="radio" name="risk" value="LOW">Low
<input type="radio" name="risk" value="HIGH">High<br>
<label for="type">Choose a Investment type:</label>
  <select name="type">
    <option value="Mutual Fund">Mutual</option>
    <option value="Unit limited Investment Plan">ULIP</option>
    <option value="Public Provident Fund">PPF</option>
    <option value="Fixed Deposit">FD</option>
    <option value="Senior Pension Scheme">Senior</option>
  </select><br>
 Purpose <select name="purpose">
    <option value="RETIREMENT">Retirement</option>
    <option value="EDUCATION">Education</option>
    <option value="MARRIAGE">Marriage</option>
  </select><br>
  Nominee <select name="nominee">
    <option value="WIFE">Wife</option>
    <option value="SON">Son</option>
    <option value="FATHER">Father</option>
    <option value="DAUGHTER">Daughter</option>
    <option value="HUSBAND">Husband</option>
  </select>
  <input type="submit" value="addInvestment">
  
</form>
</body>
</html>