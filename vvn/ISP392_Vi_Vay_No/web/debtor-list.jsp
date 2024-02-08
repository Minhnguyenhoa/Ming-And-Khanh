<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Debtor List</title>
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <style>
            /* Add custom styles here */
        </style>
    </head>
    <body>

        <%@ include file="header.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">
                    <%@ include file="sidebar.jsp" %>
                </div>
                <div class="col-md-9">
                    <div class="container mt-5">
                        <h1 class="mb-4">Debtor List</h1>

                        <c:if test="${param.success ne null}">
                            <div class="alert alert-success" role="alert">
                                Update success!
                            </div>
                        </c:if>
                        <c:if test="${param.fail ne null}">
                            <div class="alert alert-danger" role="alert">
                                Update failed!
                            </div>
                        </c:if>

                        <button type="button" class="btn btn-primary mb-3" data-toggle="modal" data-target="#addDebtorModal">Add Debtor</button>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Address</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Total Debt</th>
                                    <th>Created At</th>
                                    <th>Updated At</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="debtor" items="${debtorList}">
                                    <tr>
                                        <td>${debtor.id}</td>
                                        <td>${debtor.name}</td>
                                        <td>${debtor.address}</td>
                                        <td>${debtor.phone}</td>
                                        <td>${debtor.email}</td>
                                        <td>${debtor.totalDebt}</td>
                                        <td>${debtor.createdAt}</td>
                                        <td>${debtor.updatedAt}</td>
                                        <td>
                                            <a href="debt-details?id=${debtor.id}" class="btn btn-secondary btn-sm">Details</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <!-- Pagination -->
                        <ul class="pagination">
                            <li class="page-item <c:if test='${page <= 1}'>disabled</c:if>'">
                                <a class="page-link" href="?page=${page - 1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>

                            <c:if test="${page > 2}">
                                <li class="page-item"><a class="page-link" href="?page=${page - 2}">${page - 2}</a></li>
                                </c:if>

                            <c:if test="${page > 1}">
                                <li class="page-item"><a class="page-link" href="?page=${page - 1}">${page - 1}</a></li>
                                </c:if>

                            <li class="page-item active"><a class="page-link" href="?page=${page}">${page}</a></li>

                            <li class="page-item"><a class="page-link" href="?page=${page + 1}">${page + 1}</a></li>

                            <li class="page-item">
                                <a class="page-link" href="?page=${page + 1}" aria-disabled="false">Next</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- Add Debtor Modal -->
        <div class="modal fade" id="addDebtorModal" tabindex="-1" role="dialog" aria-labelledby="addDebtorModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addDebtorModalLabel">Add Debtor</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- Add Debtor Form -->
                        <form id="addDebtorForm" method="post" action="debtor">

                            <input type="hidden" name="creditorId" value="${creditorId}">

                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input type="text" class="form-control" id="name" name="name" required>
                            </div>
                            <div class="form-group">
                                <label for="address">Address:</label>
                                <input type="text" class="form-control" id="address" name="address" required>
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone:</label>
                                <input type="text" class="form-control" id="phone" name="phone" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>
                            <div class="form-group">
                                <label for="totalDebt">Total Debt:</label>
                                <input type="number" class="form-control" id="totalDebt" name="totalDebt" value="0" disabled>
                            </div>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>


        <!-- Bootstrap JS (optional, if you need JavaScript features) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </body>
</html>
