let design = {
    init: function () {
        $("#btn-design-add").on("click", () => {
            if (confirm("추가하시겠습니까?")) {
                this.addDesign();
            }
        });
        $("#btn-design-update-redirect").on("click", () => {
            let id = $('input[name=\"designRow\"]:checked').val();
            if (id == null) {
                alert("제품을 선택하세요.");
                return;
            }
            location.href = "/design/updateform/" + id;
        });
        $("#btn-design-update").on("click", () => {
            if (confirm("수정하시겠습니까?")) {
                this.updateDesign();
            }
        });
        $("#btn-design-delete").on("click", () => {
            let id = $('input[name=\"designRow\"]:checked').val();
            if (id == null) {
                alert("제품을 선택하세요.");
                return;
            }
            if (confirm("삭제하시겠습니끼?")) {
                this.deleteDesign(id);
            }
        });
    },
    addDesign: function () {
        let data = {
            targetProduct: $("#id").val(),
            slaveProduct: $('input[name=\"modalRow\"]:checked').val(),
            lossRate: $("#lossRate").val(),
            count: $("#count").val()
        };
        console.log(data);
        if (data.slaveProduct == null) {
            alert("제품을 선택하세요.");
            return;
        }

        if (data.targetProduct == data.slaveProduct) {
            alert("동일한 제품은 추가 할 수 없습니다.");
            return;
        }

        if (data.count <= 0 || data.count == "") {
            alert("0 이상의 값을 입력하세요.");
            document.getElementById("count").focus();
            return;
        }

        if (data.lossRate >= 100 || data.lossRate < 0 || data.lossRate == "") {
            alert("0~100 사이의 값을 입력하세요.");
            document.getElementById("lossRate").focus();
            return;
        }

        $.ajax({
            type: "POST",
            url: "/design",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf8",
            dataType: "json"
        }).done(function () {
            alert("디자인생성 완료");
            location.reload();
        }).fail(function (error) {
            alert(error.responseText);
        });
    },
    updateDesign: function () {
        let id = $("#id").val();
        let data = {
            targetProduct: $("#targetProductId").val(),
            slaveProduct: $("#slaveProductId").val(),
            lossRate: $("#lossRate").val(),
            count: $("#count").val()
        };
        if (data.count <= 0 || data.count == "") {
            alert("0 이상의 값을 입력하세요.");
            document.getElementById("count").focus();
            return;
        }

        if (data.lossRate >= 100 || data.lossRate < 0 || data.lossRate == "") {
            alert("0~100 사이의 값을 입력하세요.");
            document.getElementById("lossRate").focus();
            return;
        }

        $.ajax({
            type: "PUT",
            url: "/design/" + id,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf8",
            dataType: "json"
        }).done(function () {
            alert("디자인수정 완료");
            location.href="/product/"+data.targetProduct
        }).fail(function (error) {
            alert(error.responseText);
        });
    },


    deleteDesign: function (id) {
        $.ajax({
            type: "DELETE",
            url: "/design/" + id,
        }).done(function () {
            alert("디자인삭제 완료");
            location.reload();
        }).fail(function (error) {
            alert(error.responseText);
        });
    },
}

design.init();