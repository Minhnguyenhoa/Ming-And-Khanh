<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Debt Details</title>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
                        <h1 class="mb-4">Debt Details</h1>

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

                        <button type="button" class="btn btn-primary mb-3" data-toggle="modal" data-target="#addDebtDetailModal">Add Debt Detail</button>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Description</th>
                                    <th>Type</th>
                                    <th>Amount</th>
                                    <th>Created At</th>
                                    <th>Interest Rate</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="debtDetail" items="${debtDetails}">
                                    <tr class="${debtDetail.deptType ? '' : 'text-danger'}">
                                        <td>${debtDetail.id}</td>
                                        <td>${debtDetail.description}</td>
                                        <td>${debtDetail.deptType ? '+' : '-'}</td>
                                        <td>${debtDetail.amount}</td>
                                        <td>${debtDetail.creatAt}</td>
                                        <td>${debtDetail.interest_rate_id}%</td>
                                        <td>
                                            <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#debtDetailModal${debtDetail.id}">
                                                Details
                                            </button>
                                            <a href="debt-details?id=${debtorId}&action=delete&debtDetailsId=${debtDetail.id}" class="btn btn-danger">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal for each debt detail -->
        <c:forEach var="debtDetail" items="${debtDetails}">
            <div class="modal fade" id="debtDetailModal${debtDetail.id}" tabindex="-1" role="dialog" aria-labelledby="debtDetailModalLabel${debtDetail.id}" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="debtDetailModalLabel${debtDetail.id}">Debt Detail</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p><strong>Description:</strong> ${debtDetail.description}</p>
                            <p><strong>Amount:</strong> ${debtDetail.amount}</p>
                            <p><strong>Type:</strong> ${debtDetail.deptType ? '+' : '-'}</p>
                            <c:if test="${debtDetail.image ne null}">
                                <p><strong>Image:</strong> <img src="${debtDetail.image}" alt="Debt Detail Image" class="img-fluid"></p>
                                </c:if>
                            <!-- Add more details as needed -->
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>


        <!-- Add Debt Detail Modal -->
        <div class="modal fade" id="addDebtDetailModal" tabindex="-1" role="dialog" aria-labelledby="addDebtDetailModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addDebtDetailModalLabel">Add Debt Detail</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- Add Debt Detail Form -->
                        <form action="debt-details" method="post">

                            <input type="hidden" name="debtorId" value="${debtorId}">

                            <div class="form-group">
                                <label for="description">Description:</label>
                                <input type="text" class="form-control" id="description" name="description">
                            </div>
                            <div class="form-group">
                                <label for="debtType">Type:</label>
                                <select class="form-control" id="debtType" name="debtType">
                                    <option value="true">+</option>
                                    <option value="false">-</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="amount">Amount:</label>
                                <input type="text" class="form-control" id="amount" name="amount">
                            </div>
                            <div class="form-group">
                                <label for="image">Image:</label>
                                <input type="text" class="form-control" id="image" name="image">
                            </div>
                            <div class="form-group">
                                <label>Interest rate:</label>
                                <select class="form-control" name="interestRateId">
                                    <option value="1">1%</option>
                                    <option value="2">2%</option>
                                    <option value="5">5%</option>
                                </select>
                            </div>
                            <!-- Add more input fields as needed -->
                            <button type="submit" class="btn btn-primary">Add</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </body>
</html>
