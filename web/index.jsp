
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">
        <meta name="theme-color" content="#563d7c">
        <title> Sistema Plab - Login</title>

        <!-- FAVICON -->
        <link rel="icon" type="image/png" href="img/favicon.png">
        <!-- GOOGLE FONTS -->
        <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
        <!-- BOOTSTRAP 4.5 -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <!-- FONT AWESOME 6 -->
        <script src="https://kit.fontawesome.com/52b3994f2c.js" crossorigin="anonymous"></script>
        <!--GOOGLE ICONS-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--SCRIPTS-->
        <script src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
                integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
        <script src="js/google-login.js"></script>  
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="263569331459-iq62rdkr3aqao1fr84n8sn5q37bflaoe.apps.googleusercontent.com">


        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }


            body {
                font-size: .875rem;
            }

            .feather {
                width: 16px;
                height: 16px;
                vertical-align: text-bottom;
            }

            /*
     * Sidebar
     */

            .sidebar {
                position: fixed;
                top: 0;
                bottom: 0;
                left: 0;
                z-index: 100;
                /* Behind the navbar */
                padding: 48px 0 0;
                /* Height of navbar */
                box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);
            }

            @media (max-width: 767.98px) {
                .sidebar {
                    top: 5rem;
                }
            }

            .sidebar-sticky {
                position: relative;
                top: 0;
                height: calc(100vh - 48px);
                padding-top: .5rem;
                overflow-x: hidden;
                overflow-y: auto;
                /* Scrollable contents if viewport is shorter than content. */
            }

            @supports ((position: -webkit-sticky) or (position: sticky)) {
                .sidebar-sticky {
                    position: -webkit-sticky;
                    position: sticky;
                }
            }

            .sidebar .nav-link {
                font-weight: 500;
                color: #333;
            }

            .sidebar .nav-link .feather {
                margin-right: 4px;
                color: #999;
            }

            .sidebar .nav-link.active {
                color: #007bff;
            }

            .sidebar .nav-link:hover .feather,
            .sidebar .nav-link.active .feather {
                color: inherit;
            }

            .sidebar-heading {
                font-size: .75rem;
                text-transform: uppercase;
            }

            /*
     * Navbar
     */

            .navbar-brand {
                padding-top: .75rem;
                padding-bottom: .75rem;
                font-size: 1rem;
                background-color: rgba(0, 0, 0, .25);
                box-shadow: inset -1px 0 0 rgba(0, 0, 0, .25);
            }

            .navbar .navbar-toggler {
                top: .25rem;
                right: 1rem;
            }

            .navbar .form-control {
                padding: .75rem 1rem;
                border-width: 0;
                border-radius: 0;
            }

            .form-control-dark {
                color: #fff;
                background-color: rgba(255, 255, 255, .1);
                border-color: rgba(255, 255, 255, .1);
            }

            .form-control-dark:focus {
                border-color: transparent;
                box-shadow: 0 0 0 3px rgba(255, 255, 255, .25);
            }
        </style>

    </head>

    <body>
        <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
            <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#"><img src="img/favicon.png" alt="logo"
                                                                              style="width: 30px;height: 30px;"> Plab</a>
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse"
                    data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </nav>

        <div class="container-fluid">
            <div class="row">

                <main role="main" class="col-12">
                    <!-- {{{body}}}-->
                    <div class="container">
                        <br>
                        <br>
                        <div class="mx-auto" style="max-width: 500px;">
                            <form method="post" action="SignIn.do">
                                <h3 style="color: #007DFF; font-weight: bold;"> Bienvenido al Sistema Plab</h3>
                                <h4 style="color: #007DFF; font-weight: bold;"> Plan Básico del profesor</h4>
                                <div class="form-group">
                                    <label for="user">Correo Institucional</label>
                                    <input type="email" class="form-control" id="user" name="user"
                                           aria-describedby="emailHelp" required>

                                    <small id="emailHelp" class="form-text text-muted">Recuerda usar un correo @ufps.edu.co</small>
                                </div>
                                <label for="pass">Contraseña</label>
                                <div class="input-group">                                    
                                    <input id="pass" name="pass" type="password" class="form-control" required>
                                    <div class="input-group-append">
                                        <button id="show_password" class="btn btn-primary" type="button" onclick="togglePassword('pass')"> 
                                            <span id="eye" class="fa fa-eye icon"></span> 
                                        </button>
                                    </div>
                                </div>
                                <a href="recuperacion"><u>Olvide contraseña</u></a>
                                <hr>
                                <div style="display: flex; justify-content: left;">
                                    <button type="submit" class="btn btn-primary">Ingresar</button>                                    
                                    <div style="display: inline-block; margin:10px" id="gSignIn"></div>  
                                    <div class="g-signin2" data-onFailure="fail" data-onsuccess="onSignIn"></div>
                                </div>

                            </form>
                        </div>
                    </div>
                    <div style="width: 100%;height: 100%;background-image: url('img/bg.jpg'); background-size: cover;">
                    </div>

                    <%
                        String msg = (String) request.getSession().getAttribute("msg");
                        if (msg != null) {
                    %>
                    <!-- Modal success -->                        
                    <div class="modal fade" id="ventana" tabindex="-1" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Mensaje</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <p><%=msg%></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Modal  -->

                    <%
                        }
                        request.getSession().removeAttribute("msg");
                    %>

                    <!-- {{{/body}}}-->
                </main>

            </div>
        </div>
        <script>
            
            $(document).ready(function () {
                $("#ventana").modal('show');
            });
            
            function togglePassword(inputId) {
                var tipo = document.getElementById(inputId);
                if (tipo.type === "password") {
                    tipo.type = "text";
                    $("#eye").removeClass("fa-eye");
                    $("#eye").addClass("fa-eye-slash");                     
                } else {
                    tipo.type = "password";
                    $("#eye").removeClass("fa-eye-slash");
                    $("#eye").addClass("fa-eye");                                       
                }
            }
        </script>
    </body>

</html>