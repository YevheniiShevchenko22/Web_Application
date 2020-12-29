$(document).ready(function () {
    $('image').change(function () {
        showImageView(this);
    });
});

function showImageView(fileInput) {
    file = fileInput.files[0];
    reader = new FileReader();

    reader.onload = function (e) {
        $('#view').attr('src', e.target.result)
    };

    reader.readAsDataURL(file);
}