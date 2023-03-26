var productAPI = "http://localhost:8080/product";
var categoryAPI = " http://localhost:8080/category";
var statusAPI = "http://localhost:8080/status";
var brandAPI = "http://localhost:8080/brand";
var subCategoryAPI = "http://localhost:8080/subcategory";


function productCtrl($scope, $http, $routeParams) {


    $scope.idUrl = $routeParams.id;



    // List Page

    $scope.offset = 0;
    $scope.pagesize = 5;
    $scope.listPage = [];


    $http
        .get(productAPI + "/" + $scope.offset + "/" + $scope.pagesize)
        .then(function (response) {
            $scope.listPage = response.data;
            $scope.listProductWithPage = $scope.listPage.response.content;
            $scope.total = $scope.listPage.response.totalPages
        })

    // next page
    $scope.nextPage = function () {
        $scope.offset++;
        if ($scope.offset + 1 > $scope.listPage.response.totalPages) {
            $scope.offset = $scope.listPage.response.totalPages - 1;
        } else {
            $http
                .get(productAPI + "/" + $scope.offset + "/" + $scope.pagesize)
                .then(function (response) {
                    $scope.listPage = response.data;
                    $scope.listProductWithPage = $scope.listPage.response.content;
                    $scope.total = $scope.listPage.response.totalPages
                })
        }

    }
    // previous page
    $scope.previousPage = function () {
        $scope.offset--;
        if ($scope.offset + 1 < 1) {
            $scope.offset = 0;
        } else {
            $http
                .get(productAPI + "/" + $scope.offset + "/" + $scope.pagesize)
                .then(function (response) {
                    $scope.listPage = response.data;
                    $scope.listProductWithPage = $scope.listPage.response.content;
                    $scope.total = $scope.listPage.response.totalPages
                })
        }
    }


    // List product
    $scope.listProduct = [];
    $http
        .get(productAPI)
        .then(function (response) {
            $scope.listProduct = response.data;
        });

    // List category
    $scope.listCategory = [];
    $scope.idCategory = $scope.listCategory[0]
    $http
        .get(categoryAPI)
        .then(function (response) {
            $scope.listCategory = response.data;
        });

    // list status
    $scope.listStatus = [];

    $http
        .get(statusAPI)
        .then(function (response) {
            $scope.listStatus = response.data;
        });

    // list brand
    $scope.listBrand = [];
    $http
        .get(brandAPI)
        .then(function (response) {
            $scope.listBrand = response.data;
        });

    // list subcategory
    $scope.listSubCategory = [];
    $http
        .get(subCategoryAPI)
        .then(function (response) {
            $scope.listSubCategory = response.data;
        });




    // productEmpty add
    $scope.productEmpty = {
        id: 0,
        productName: "",
        color: "",
        quantity: 0,
        sellPrice: 0,
        originPrice: 0,
        description: "",
        status: {
            id: 1,
            statusName: 0
        },
        subCategory: {
            id: 0,
        },
        brand: [
            {
                id: 0,
                brandName: ""
            }
        ]
    },
        // Add product
        $scope.addProduct = function () {
            $http
                .post(productAPI, $scope.productEmpty)
                .then(function () {
                    $scope.listProduct.push($scope.productEmpty);

                    alert("Add Product Successful !!!!")
                    $http
                        .get(productAPI)
                        .then(function (response) {
                            $scope.listProduct = response.data;
                        });
                })
                .catch(function (error) {
                    console.log(error);
                    alert("Add Product Failed!!!");
                })
        };

    // Update product
    $scope.updateProduct = function () {
        const idUpdate = $routeParams.id;
        $http
            .put(productAPI + "/" + idUpdate, $scope.productEmpty)
            .then(function () {
                alert("Update Product Successfull!!!");
                $http
                    .get(productAPI)
                    .then(function (response) {
                        $scope.listProduct = response.data;
                    });
            })
            .catch(function (e) {
                console.log(e);
            })
    };
    // Detail product
    $scope.detailProduct = function (index) {
        const idDetail = $scope.listProduct[index].id;
        $http
            .get(productAPI + "/" + idDetail)
            .then(function (response) {
                $scope.productEmpty = response.data;

                $scope.idCategory = $scope.productEmpty.subCategory.category.id

                // $scope.idBrand = $scope.productEmpty.brand[0].id

                $scope.listSubCategorybyId = [];
                const idCategory = $scope.idCategory;
                $http
                    .get(subCategoryAPI + "/" + idCategory)
                    .then(function (response) {
                        $scope.listSubCategorybyId = response.data;

                    })
                    .catch(function (error) {
                        console.log(error);
                    })
            })
            .catch(function (error) {
                console.log(error);
            })
    };
    // Delete product
    $scope.deleteProduct = function (index) {
        const idDelete = $scope.listProduct[index].id
        $http
            .delete(productAPI + "/" + idDelete)
            .then(function () {
                $scope.listProduct.splice(index, 1);
                alert("Delete Product Successfull!!!");
            })
            .catch(function (e) {
                console.log(e);
            })
    };
    // Delete product page
    $scope.deleteProductPage = function (index) {
        const idDelete = $scope.listProductWithPage[index].id
        console.log(idDelete);
        $http
            .delete(productAPI + "/" + idDelete)
            .then(function () {
                $scope.listProduct.splice(index, 1);
                $http
                    .get(productAPI + "/" + $scope.offset + "/" + $scope.pagesize)
                    .then(function (response) {
                        $scope.listPage = response.data;
                        $scope.listProductWithPage = $scope.listPage.response.content;
                        $scope.total = $scope.listPage.response.totalPages
                    })
                alert("Delete Product Page Successfull!!!");
            })
            .catch(function (e) {
                console.log(e);
            })
    };
    // change category
    $scope.changeCategory = function () {
        $scope.listSubCategorybyId = [];
        const idCategory = $scope.idCategory;
        $http
            .get(subCategoryAPI + "/" + idCategory)
            .then(function (response) {
                $scope.listSubCategorybyId = response.data;

            })
            .catch(function (error) {
                console.log(error);
            })
    }


    // Sort colum
    $scope.sortColumn = "productName";
    $scope.reverse = false;
    $scope.sortData = function(column){
        $scope.reverse = ($scope.sortColumn == column)?!$scope.reverse : false;
        $scope.sortColumn = column;
    }

}