<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html style="font-size: 15px;font-family: Lato, sans-serif;">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>New Trainer</title>

        <c:url value="css/style.css" var="cssLink"/>
        <link rel="stylesheet" href="${cssLink}">
        <c:url value="css/jquery-ui.css" var="cssLink1"/>
        <link rel="stylesheet" href="${cssLink1}">
        <c:url value="css/bootstrap.min.css" var="cssLink2"/>
        <link rel="stylesheet" href="${cssLink2}">
        <c:url value="https://fonts.googleapis.com/css?family=Lato:300,400,700" var="cssLink3"/>
        <link rel="stylesheet" href="${cssLink3}">
        <c:url value="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css" var="cssLink4"/>
        <link rel="stylesheet" href="${cssLink4}">
        <c:url value="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css" var="cssLink5"/>
        <link rel="stylesheet" href="${cssLink5}">
        <c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" var="cssLink6"/>
        <link rel="stylesheet" href="${cssLink6}" >




    </head>

     <body class="trainer_form" style="background-image: url(&quot;${pageContext.request.contextPath}/img/asd.jpg&quot;);">
        <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient" style="font-size: 17px;opacity: 1;background-image: url(&quot;${pageContext.request.contextPath}/img/CODE.jpg&quot;);background-position: top;background-size: cover;background-repeat: no-repeat;">
            <div class="container"><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarNav"><span
                        class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button><a class="navbar-brand logo" href="${pageContext.request.contextPath}/" style="filter: blur(0px);background-image: url(&quot;${pageContext.request.contextPath}/img/CODE.jpg&quot;);">CODING&nbsp;
                    SCHOOL&nbsp;</a>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#" style="color: rgb(255,255,255);">Trainers</a>
                            <div class="dropdown-menu" role="menu" data-aos="zoom-in"><a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/new">Add Trainer</a><a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/">Edit Trainer</a></div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <h1>This is my List of trainers</h1>
        <br>
            <h1 id="trainers1">Trainers</h1>
            <p id="messagaki">
                ${message}
            </p>
            <a id="buttonaki" class="btn btn-primary" href="${pageContext.request.contextPath}/new">Add trainer</a>
        <div id="divakiola">
            <table border="1" id="tableaki" class="table table-striped table-dark">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Last Name</th>
                        <th>Subject</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfTrainers}" var = "trainer">
                    <tr>
                        <td>${trainer.tid}</td>
                        <td>${trainer.tname}</td>
                        <td>${trainer.tlname}</td>
                        <td>${trainer.tsubject}</td>
                        <td>      
                            <a href="${pageContext.request.contextPath}/update/${trainer.tid}">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/delete?id=${trainer.tid}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        
    </div>
    
    
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
    <script src="js/script.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/script.js"></script>
</body>
<footer><div style="position:fixed;float:bottom" class="footer">Panagiotis Lianos - Coding Bootcamp 12 &copy; 2021</div></footer>

</html>