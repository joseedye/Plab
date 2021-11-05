

<%@page import="java.util.Map"%>
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
        <title> Actividades</title>

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
                                <a class="nav-link" href="registrar_actividad.jsp">
                                    <i class="fas fa-user-plus"></i> Registrar actividad
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="../QueryActivity.do">
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
                    <%
                        Map<String, String> user = (Map<String, String>) request.getSession().getAttribute("user");
                        String userImg = (String) request.getSession().getAttribute("userImg");
                        Map<String, Object> docencia = (Map<String, Object>) request.getSession().getAttribute("docencia");
                        Map<String, Object> administracion = (Map<String, Object>) request.getSession().getAttribute("administracion");
                        Map<String, Object> extension = (Map<String, Object>) request.getSession().getAttribute("extension");
                        Map<String, Object> investigacion = (Map<String, Object>) request.getSession().getAttribute("investigacion");
                        Map<String, Object> otras = (Map<String, Object>) request.getSession().getAttribute("otras");
                        String hsemana = (String) request.getSession().getAttribute("hsemana");
                        String hsemestre = (String) request.getSession().getAttribute("hsemestre");

                    %>
                    <!--TABLE FILTER-->
                    <link href="../dependencies/dataTables.bootstrap4.min.css" rel="stylesheet">
                    <script src="../dependencies/table.js"></script>
                    <script src="../dependencies/dataTables.bootstrap4.min.js"></script>
                    <br>
                    <h4>Mis actividades</h4>
                    <br>
                    <div class="card p-4 shadow bg-primary text-white">
                        <h4>Carga horaria semanal</h4>
                        <%=hsemana%>
                        <h4>Carga horaria semestral</h4>
                        <%=hsemestre%>
                    </div>
                    <br>




                    <div class="accordion" id="accordionExample">
                        <div class="card">
                            <div class="" id="headingOne">
                                <h2 class="mb-0">
                                    <button class="btn btn-outline-light text-dark text-decoration-none btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                        <h5><i class="fas fa-chalkboard-teacher"></i> Actividades de docencia</h5>
                                    </button>
                                </h2>
                            </div>

                            <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="table1" class="table table-striped table-bordered" style="width:100%">
                                            <thead>
                                                <tr>
                                                    <th>Código</th>
                                                    <th>Grupo</th>
                                                    <th>Nombre</th>
                                                    <th>Créd</th>
                                                    <th># de estudiantes</th>
                                                    <th>Nivel</th>
                                                    <th>Horas semanal Teóricas</th>
                                                    <th>Horas semanal Teóricas Prácticas</th>
                                                    <th>Horas semanal Prácticas</th>
                                                    <th>Total horas semanal</th>
                                                    <th>Total horas semestral</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%  for (Map.Entry<String, Object> entry : docencia.entrySet()) {
                                                        Map<String, String> map = (Map<String, String>) entry.getValue();
                                                %>
                                                <tr>
                                                    <td>
                                                        <%=map.get("codigo")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("grupo")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("nombre")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("creditos")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("nestudiantes")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("nivel")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("ht")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("htp")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("hp")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("hsemana")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("hsemestre")%>
                                                    </td>
                                                    <td>
                                                        <a class="btn btn-danger" href="../DeleteActivity.do?verificador=0&id=<%=map.get("id")%>"> <i class="far fa-trash-alt"></i></a>
                                                    </td>
                                                </tr>
                                                <% }%>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="" id="headingTwo">
                                <h2 class="mb-0">
                                    <button class="btn btn-outline-light text-dark text-decoration-none btn-block text-left" type="
                                            button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                        <h5><i class="fas fa-search"></i> Actividades de investigación</h5>
                                    </button>
                                </h2>
                            </div>
                            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="table2" class="table table-striped table-bordered" style="width:100%">
                                            <thead>
                                                <tr>
                                                    <th>Código</th>
                                                    <th>Actividad</th>
                                                    <th>Responsabilidad</th>
                                                    <th>Unidad investigativa</th>
                                                    <th>Institucional</th>
                                                    <th>Horas semanal</th>

                                            </thead>
                                            <tbody>
                                                <%  for (Map.Entry<String, Object> entry : investigacion.entrySet()) {
                                                        Map<String, String> map = (Map<String, String>) entry.getValue();
                                                %>
                                                <tr>
                                                    <td>
                                                        <%=map.get("codigo")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("nombre")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("responsabilidad")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("unidad")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("institucion")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("hsemana")%>
                                                    </td>
                                                    <td>
                                                        <a class="btn btn-danger" href="../DeleteActivity.do?verificador=1&id=<%=map.get("id")%>"> <i class="far fa-trash-alt"></i></a>
                                                    </td>
                                                </tr>
                                                <% }%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="" id="headingThree">
                                <h2 class="mb-0">
                                    <button class="btn btn-outline-light text-dark text-decoration-none btn-block text-left" type="
                                            button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                        <h5><i class="fas fa-level-up-alt"></i> Actividades de Extensión</h5>
                                    </button>
                                </h2>
                            </div>
                            <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="table3" class="table table-striped table-bordered" style="width:100%">
                                            <thead>
                                                <tr>
                                                    <th>Código</th>
                                                    <th>Descripcion actividad</th>
                                                    <th>Responsabilidades</th>
                                                    <th>Unidad</th>
                                                    <th>Programa o Beneficiario</th>
                                                    <th>Horas semanal Ejecucion</th>
                                                    <th>Horas semanal Programación</th>
                                                    <th>Total horas semana</th>
                                                    <th>Total horas semestre</th>
                                                    <th>
                                                    </th>
                                            </thead>
                                            <tbody>
                                                <%  for (Map.Entry<String, Object> entry : extension.entrySet()) {
                                                        Map<String, String> map = (Map<String, String>) entry.getValue();
                                                %>
                                                <tr>
                                                    <td>
                                                        <%=map.get("codigo")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("nombre")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("responsabilidades")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("unidad")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("programa")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("hejecucion")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("hprogramacion")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("hsemana")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("hsemestre")%>
                                                    </td>
                                                    <td>
                                                        <a class="btn btn-danger" href="../DeleteActivity.do?verificador=2&id=<%=map.get("id")%>"> <i class="far fa-trash-alt"></i></a>
                                                    </td>
                                                </tr>
                                                <% }%>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="" id="headingFour">
                                <h2 class="mb-0">
                                    <button class="btn btn-outline-light text-dark text-decoration-none btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour">
                                        <h5><i class="fas fa-users-cog"></i> Administración Académica</h5>
                                    </button>
                                </h2>
                            </div>

                            <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="table4" class="table table-striped table-bordered" style="width:100%">
                                            <thead>
                                                <tr>
                                                    <th>Actividad</th>
                                                    <th>Cargo</th>
                                                    <th>Horas semana</th>
                                                    <th>Horas semestre</th>
                                                    <th> </th>
                                            </thead>
                                            <tbody>
                                                <%  for (Map.Entry<String, Object> entry : administracion.entrySet()) {
                                                        Map<String, String> map = (Map<String, String>) entry.getValue();
                                                %>
                                                <tr>
                                                    <td>
                                                        <%=map.get("nombre")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("cargo")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("hsemana")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("hsemestre")%>
                                                    </td>
                                                    <td>
                                                        <a class="btn btn-danger" href="../DeleteActivity.do?verificador=3&id=<%=map.get("id")%>"> <i class="far fa-trash-alt"></i></a>
                                                    </td>
                                                </tr>
                                                <% }%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="" id="headingFive">
                                <h2 class="mb-0">
                                    <button class="btn btn-outline-light text-dark text-decoration-none btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseFive" aria-expanded="true" aria-controls="collapseFive">
                                        <h5><i class="fas fa-school"></i> Otras actividades</h5>
                                    </button>
                                </h2>
                            </div>

                            <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordionExample">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="table5" class="table table-striped table-bordered" style="width:100%">
                                            <thead>
                                                <tr>
                                                    <th>Identificación de la actividad</th>
                                                    <th>Horas semana</th>
                                                    <th>Horas semestre</th>
                                                    <th> </th>
                                            </thead>
                                            <tbody>
                                                <%  for (Map.Entry<String, Object> entry : otras.entrySet()) {
                                                        Map<String, String> map = (Map<String, String>) entry.getValue();
                                                %>
                                                <tr>
                                                    <td>
                                                        <%=map.get("nombre")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("hsemana")%>
                                                    </td>
                                                    <td>
                                                        <%=map.get("hsemestre")%>
                                                    </td>
                                                    <td>
                                                        <a class="btn btn-danger" href="../DeleteActivity.do?verificador=4&id=<%=map.get("id")%>"> <i class="far fa-trash-alt"></i></a>
                                                    </td>
                                                </tr>
                                                <% }%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                    <br>

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
                                    <p>
                                        <%=msg%>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Modal  -->

                    <%
                        }
                        request.getSession().removeAttribute("msg");
                    %>



                    <script>
                        //Table
                        $(document).ready(function () {
                            $('#table1').DataTable();
                        });
                        $(document).ready(function () {
                            $('#table2').DataTable();
                        });
                        $(document).ready(function () {
                            $('#table3').DataTable();
                        });
                        $(document).ready(function () {
                            $('#table4').DataTable();
                        });
                        $(document).ready(function () {
                            $('#table5').DataTable();
                        });

                        $(document).ready(function () {
                            $("#ventana").modal('show');
                        });
                    </script>
                    <br>

                    <!-- {{{/body}}}-->
                </main>

            </div>
        </div>



    </body>

</html>