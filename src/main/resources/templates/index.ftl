<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
        "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>SimpleGroupTest</title>
    <script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui.js"></script>
    <script type="text/javascript" src="../js/main.js"></script>
    <script type="text/javascript" src="../js/dateFormat.js"></script>
    <link rel="stylesheet" href="../css/jquery-ui.css">
    <script type="text/javascript">
        $(document).ready(function () {
            Utils.load();
        })
    </script>
</head>
<body>
    <table>
        <tr>
            <td>
                firstName
            </td>
            <td>
                <input type="text" id="firstName">
            </td>
        </tr>
        <tr>
            <td>
                secondName
            </td>
            <td>
                <input type="text" id="secondName">
            </td>
        </tr>
        <tr>
            <td>
                middleName
            </td>
            <td>
                <input type="text" id="middleName">
            </td>
        </tr>
        <tr>
            <td>
                birthDate
            </td>
            <td>
                <input type="text" id="birthDate">
            </td>
        </tr>
    </table>
    <input type="button" value="Save" onclick="Utils.save();">
</body>
</html>

