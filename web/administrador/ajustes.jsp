

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
        <title> Ajustes</title>

        <!-- FAVICON -->
        <link rel="icon" type="image/png" href="/img/favicon.png">
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
            <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#"><img src="/img/favicon.png" alt="logo"
                                                                              style="width: 30px;height: 30px;"> Ajustes</a>
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse"
                    data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <ul class="navbar-nav px-3">
                <li class="nav-item text-nowrap">
                    <a class="nav-link" href="../LogOut.do">Salir</a>
                </li>
            </ul>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                    <div class="sidebar-sticky pt-3">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link" href="../QueryProfesor.do?page=progreso">
                                    <i class="fas fa-chart-pie"></i>
                                    Progreso
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="registrar_profesor.jsp">
                                    <i class="fas fa-user-plus"></i>
                                    Registrar profesor
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../QueryProfesor.do">
                                    <i class="fas fa-user-edit"></i>
                                    Editar profesor
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="registrar_actividad.jsp">
                                    <i class="fas fa-user-plus"></i> Registrar actividad
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../QueryActivity.do">
                                    <i class="fas fa-business-time"></i>
                                    Actividades
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="carga_horaria.jsp">
                                    <i class="fas fa-chart-bar"></i>
                                    Carga horaria
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="ajustes.jsp">
                                    <i class="fas fa-cog"></i>
                                    Ajustes
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../LogOut.do">
                                    <i class="fas fa-sign-out-alt"></i>
                                    Salir
                                </a>
                            </li>

                        </ul>
                    </div>
                </nav>

                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
                    <!-- {{{body}}}-->
                    <h2 class="mt-3 mb-3">Ajustes</h2>
                    <hr class="mx-2">
                    <br>
                    <div class="custom-control custom-switch">
                        <input type="checkbox" class="custom-control-input" id="customSwitch1">
                        <label class="custom-control-label" for="customSwitch1">Enviarme un correo cuando un docente termine
                            de registrar todas sus actividades.</label>
                    </div>
                    <div class="custom-control custom-switch">
                        <input type="checkbox" class="custom-control-input" id="customSwitch2">
                        <label class="custom-control-label" for="customSwitch2">Enviarme un correo cuando un docente
                            registre una actividad.</label>
                    </div>
                    <div class="custom-control custom-switch">
                        <input type="checkbox" class="custom-control-input" id="customSwitch3">
                        <label class="custom-control-label" for="customSwitch3">Enviarme una alerta cuando un docente sea
                            registrado con menos de 48 horas semanales.</label>
                    </div>
                    <br>
                    <a href="" class="btn btn-outline-danger">Nuevo semestre</a>
                    <br> <br>
                    <div class="card text-white bg-danger mb-3" style="max-width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Atención</h5>
                            <p class="card-text">Al crear un nuevo semestre, todos los profesores serán archivados y deberán
                                ser registrados de
                                nuevo</p>
                            <hr>
                            <p class="card-text">Todas las estadísticas de semestre actual serán reiniciadas</p>
                            <hr>
                            <p class="card-text">Aún podrás ver las estadísticas de semestres pasados</p>
                        </div>
                    </div>


                    <!-- {{{/body}}}-->
                </main>

            </div>
        </div>



    </body>

</html>