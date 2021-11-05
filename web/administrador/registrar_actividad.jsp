
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">
        <meta name="theme-color" content="#563d7c">
        <title> Registro Actividades</title>

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
                                                                              style="width: 30px;height: 30px;"> Registro</a>
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
                <!--SIDEBAR-->
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
                                <a class="nav-link active" href="registrar_actividad.jsp">
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
                                <a class="nav-link " href="ajustes.jsp">
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
                
                <!--MAIN-->
                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
                    <!-- {{{body}}}-->
                    <br>
                    <h4>Registrar actividad</h4>
                    <hr class="mx-4">
                    <br>

                    <h5>Elegir tipo de Actividad</h5>
                    <div class="btn-group">
                        <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Tipo Actividad
                        </button>

                        <div class="dropdown-menu">
                            <a class="dropdown-item" onclick="activarDocencia()" href="#">Docencia</a>
                            <a class="dropdown-item" onclick="activarInvestigacion()" href="#">Investigacion</a>
                            <a class="dropdown-item" onclick="activarExtension()" href="#">Extension</a>
                            <a class="dropdown-item" onclick="activarAdministracion()" href="#">Administracion</a>
                            <div class="dropdown-divider"></div>                            
                            <a class="dropdown-item" onclick="activarOtras()" href="#">Otras</a>
                        </div>
                    </div>
                    <br>
                    <br>

                    <!-- campos investigacion-->
                    <div id="divinvestigacion" style="display:none" class="card p-4">
                        <h4>Actividad de investigacion</h4>
                        <br>
                        <form method="post" action="../RegisterInvestigacion.do">
                            <div class="form-group">
                                Código
                                <input name="icodigo"  type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                Actividad
                                <input name="inombre" type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                Responsabilidad
                                <input name="iresponsabilidad" type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                Unidad Investigativa
                                <input name="iunidad" type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                Institucion
                                <input name="iinstitucion" type="text" value="UFPS" class="form-control">
                            </div>
                            
                            <div class="form-group">
                                Horas semanal
                                <input name="ihsemana" type="number" class="form-control">
                            </div>
                            <button type="submit" class="btn btn-primary">Registrar</button>
                        </form>
                    </div>

                    <!-- campos docencia-->
                    <div id="divdocencia" style="display:none" class="card p-4">
                        <h4>Actividad de docencia</h4>
                        <br>
                        <form method="post" action="../RegisterDocencia.do">
                            <div class="form-group">
                                Código
                                <input name="dcodigo" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                Grupo
                                <input name="dgrupo" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                Nombre
                                <input name="dnombre" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                Créditos
                                <input name="dcreditos" type="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                # de estudiantes
                                <input name="dnestudiantes" type="number" class="form-control" required>
                            </div>

                            <div class="form-group">
                                
                                Nivel <br> <br>
                                <input name="dnivel" type="radio" value="Pregrado"> Pregrado<br>
                                <input type="radio" name="dnivel" value="Postgrado"> Postgrado<br>
                            </div>
                            <div class="form-group">
                                Horas semanal Teóricas
                                <input name="dht" type="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                Horas semanal Teóricas Prácticas
                                <input name="dhtp"type="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                Horas semanal Prácticas
                                <input name="dhp" ype="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                Horas semana
                                <input name="dhsemana" type="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                Horas semestre
                                <input name="dhsemestre" type="number" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Registrar</button>
                        </form>
                    </div>
                    
                    <!-- campos extension-->
                    <div id="divextension" style="display:none" class="card p-4">
                        <h4>Actividad de extensión</h4>
                        <br>
                        <form method="post" action="../RegisterExtension.do">
                            <div class="form-group">
                                Código
                                <input name="ecodigo" type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                Nombre
                                <input name="enombre" type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                Responsabilidades
                                <input name="eresponsabilidades" type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                Unidad
                                <input name="eunidad" type="text" class="form-control">
                            </div>                            
                            <div class="form-group">
                                Programa o beneficiario
                                <input name="eprograma" type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                Horas semanal Ejecucion
                                <input name="ehejecucion" type="number" class="form-control">
                            </div>
                            <div class="form-group">
                                Horas semanal Programación
                                <input name="ehprogramacion" type="number" class="form-control">
                            </div>
                            <div class="form-group">
                                Horas semana
                                <input name="ehsemana" type="number" class="form-control">
                            </div>
                            <div class="form-group">
                                Horas semestre
                                <input name="ehsemestre" type="number" class="form-control">
                            </div>
                            <button type="submit" class="btn btn-primary">Registrar</button>
                        </form>
                    </div>
                    
                    <!-- campos administracion-->
                    <div id="divadministracion" style="display:none" class="card p-4">
                        <h4>Actividad de Administración Académica</h4>
                        <br>
                        <form method="post" action="../RegisterAdministracion.do">
                            <div class="form-group">
                                Actividad
                                <input name="anombre" type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                Cargo
                                <input name="acargo" type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                Horas semana
                                <input name="ahsemana" type="number" class="form-control">
                            </div>
                            <div class="form-group">
                                Horas semestre
                                <input name="ahsemestre" type="number" class="form-control">
                            </div>
                            <button type="submit" class="btn btn-primary">Registrar</button>
                        </form>
                    </div>
                    
                    <!-- campos otras-->
                    <div id="divotras" style="display:none" class="card p-4">
                        <h4>Otra actividad</h4>
                        <br>
                        <form method="post" action="../RegisterOtras.do">                            
                            <div class="form-group">
                                Nombre
                                <input name="onombre" type="text" class="form-control">
                            </div>
                            <div class="form-group">
                                Horas semana
                                <input name="ohsemana" type="number" class="form-control">
                            </div>
                            <div class="form-group">
                                Horas semestre
                                <input name="ohsemestre" type="number" class="form-control">
                            </div>
                            <button type="submit" class="btn btn-primary">Registrar</button>
                        </form>
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
            
            function activarDocencia() {
      
               $('#divdocencia').show();
               $("#divinvestigacion").hide();
               $("#divextension").hide();
               $("#divadministracion").hide();
               $("#divotras").hide();
            }
            function activarExtension() {
      
               $('#divextension').show();
               $("#divinvestigacion").hide();
               $("#divdocencia").hide();
               $("#divadministracion").hide();
               $("#divotras").hide();
            }
            function activarInvestigacion() {
      
               $('#divinvestigacion').show();
               $("#divdocencia").hide();
               $("#divextension").hide();
               $("#divadministracion").hide();
               $("#divotras").hide();
            }
            function activarAdministracion() {
      
               $('#divadministracion').show();
               $("#divinvestigacion").hide();
               $("#divextension").hide();
               $("#divdocencia").hide();
               $("#divotras").hide();
            }
            function activarOtras() {
      
               $('#divotras').show();
               $("#divinvestigacion").hide();
               $("#divextension").hide();
               $("#divadministracion").hide();
               $("#divdocencia").hide();
            }
        </script>
      
    </body>

</html>