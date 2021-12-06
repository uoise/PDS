let index = {
    init: function () {
        $("#btn-product-save").on("click", () => {
            if (this.valid()) {
                this.save();
            }
        });
        $("#btn-product-update").on("click", () => {
            if (this.valid()) {
                this.update();
            }
        });
        $("#btn-product-delete").on("click", () => {
            if (confirm("삭제하시겠습니까?")) {
                this.delete();
            }
        });
    },
    save: function () {
        let formData = {
            name: $("#name").val(),
            standard: $("#standard").val(),
            unit: $("#unit").val(),
            price: $("#price").val(),
            company: $("#company").val()
        };
        $.ajax({
            type: "POST",
            url: "/product",
            data: JSON.stringify(formData),
            contentType: "application/json; charset=utf8",
            dataType: "json"
        }).done(function () {
            alert("제품 생성 완료");
            location.href = "/product";
        }).fail(function (error) {
            alert(error.responseText);
        });
    },
    update: function () {
        let id = $("#id").val();
        let formData = {
            name: $("#name").val(),
            standard: $("#standard").val(),
            unit: $("#unit").val(),
            price: $("#price").val(),
            company: $("#company").val()
        };
        $.ajax({
            type: "PUT",
            url: "/product/" + id,
            data: JSON.stringify(formData),
            contentType: "application/json; charset=utf8",
            dataType: "json"
        }).done(function () {
            alert("제품 수정 완료");
            location.href = "/product"
        }).fail(function (error) {
            alert(error.responseText);
        });
    },
    delete: function () {
        let id = $("#id").val();
        $.ajax({
            type: "DELETE",
            url: "/product/" + id,
            contentType: "application/json; charset=utf8",
            dataType: "json"
        }).done(function () {
            alert("제품 삭제 완료");
            location.href = "/product"
        }).fail(function (error) {
            alert(error.responseText);
        });
    },
    valid: function () {
        let formData = {
            name: $("#name").val(),
            standard: $("#standard").val(),
            unit: $("#unit").val(),
            price: $("#price").val(),
            company: $("#company").val()
        };
        console.log(formData);
        if (formData.name == "") {
            alert("이름을 입력하세요.");
            document.getElementById("name").focus();
            return false;
        }
        if (formData.price == "") {
            alert("가격을 입력하세요.");
            document.getElementById("price").focus();
            return false;
        } else if (formData.price < 0) {
            alert("0 이상의 가격을 입력하세요.");
            document.getElementById("price").focus();
            return false;
        }
        if (formData.company == "" || formData.company == null) {
            alert("회사를 선택하세요.");
            document.getElementById("company").focus();
            return false;
        }
        return true;
    }
}

index.init();