let index = {
    init: function () {
        $("#btn-company-save").on("click", () => {
            if (this.valid()) {
                this.save();
            }
        });
        $("#btn-update").on("click", () => {
            if (this.valid()) {
                this.update();
            }
        });
        $("#btn-delete").on("click", () => {
            if (confirm("삭제하시겠습니까?")) {
                this.delete();
            }
        });
    },
    valid: function () {
        let formData = {
            name: $("#name").val(),
        };

        if (formData.name == "") {
            alert("이름을 입력하세요.");
            document.getElementById("name").focus();
            return false;
        }
        return true;
    },

    save: function () {
        let formData = {
            name: $("#name").val(),
        };
        $.ajax({
            type: "POST",
            url: "/company",
            data: JSON.stringify(formData),
            contentType: "application/json; charset=utf8",
            dataType: "json"
        }).done(function () {
            alert("회사 생성 완료");
            location.href = "/company"
        }).fail(function (error) {
            alert(error.responseText);
        });
    },

    update: function () {
        let id = $("#id").val();
        let formData = {
            targetProductId: $("#targetProductId").val(),
            targetSlaveId: $("#targetSlaveId").val(),
            lossRate: $("#lossRate").val(),
            count: $("#count").val()
        };

        $.ajax({
            type: "PUT",
            url: "/company/" + id,
            data: JSON.stringify(formData),
            contentType: "application/json; charset=utf8",
            dataType: "json"
        }).done(function (resp) {
            alert("회사수정 완료");
            location.href = "/company"
        }).fail(function (error) {
            alert("회사수정 실패");
        });
    },
    delete: function () {
        let id = $("#id").val();

        $.ajax({
            type: "DELETE",
            url: "/company",
            data: JSON.stringify(id),
            contentType: "application/json; charset=utf8",
            dataType: "json"
        }).done(function (resp) {
            alert("회사삭제 완료");
            location.href = "/company"
        }).fail(function (error) {
            alert("회사삭제 실패");
        });
    }

}

index.init();