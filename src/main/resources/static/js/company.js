let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });
        $("#btn-delete").on("click", () => {
            this.delete();
        });
    },
    save: function () {
        let data = {
            name: $("#name").toString(),
        };

        $.ajax({
            type: "POST",
            url: "/company",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf8",
            dataType: "json"
        }).done(function (resp) {
            alert("회사생성 완료");
            location.href = "/company"
        }).fail(function (error) {
            alert("회사생성 실패");
        });
    },

    update: function () {
        let id = $("#id").val();
        let data = {
            targetProductId: $("#targetProductId").val(),
            targetSlaveId: $("#targetSlaveId").val(),
            lossRate: $("#lossRate").val(),
            count: $("#count").val()
        };

        $.ajax({
            type: "PUT",
            url: "/company/"+id,
            data: JSON.stringify(data),
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
        let data = $("#id").val();

        $.ajax({
            type: "DELETE",
            url: "/company",
            data: JSON.stringify(data),
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