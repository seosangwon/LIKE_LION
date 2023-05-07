document.addEventListener("DOMContentLoaded", function() {
    const toggleButton = document.getElementById("toggleButton");
    const paragraphs = document.querySelectorAll("p");

    toggleButton.addEventListener("click", function() {
        paragraphs.forEach(function (paragraph) {
            if (paragraph.classList.contains("hidden")) {
                paragraph.classList.remove("hidden");
                paragraph.style.display = "block";
            } else {
                paragraph.classList.add("hidden");
                paragraph.style.display = "none";
            }
        });
    });
});


document.addEventListener("DOMContentLoaded", function() {
    const inputElement = document.querySelector(".input");
    const askButton = document.getElementById("ask");
    const questionsContainer = document.getElementById("questions");

    // 클릭 시 input 텍스트 초기화
    inputElement.addEventListener("focus", function() {
        if (inputElement.value === "궁금한점이 있다면") {
            inputElement.value = "";
        }
    });

    // 버튼 클릭 시 input 데이터를 p 태그로 추가
    askButton.addEventListener("click", function() {
        if (inputElement.value.trim() !== "" && inputElement.value !== "궁금한점이 있다면") {
            const newQuestion = document.createElement("p");
            newQuestion.textContent = inputElement.value;
            questionsContainer.appendChild(newQuestion);
            inputElement.value = "";
        }
    });
});
