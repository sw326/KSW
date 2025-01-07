```mermaid
flowchart TD
    A[고객이 일기 작성] --> B[일기 텍스트 입력]
    
    subgraph AI_분석
        B --> C{감정 분석}
        B --> D{주요 내용 추출}
        B --> E{맥락 파악}
        
        C --> F[감정 카테고리 분류]
        F --> F1[기쁨]
        F --> F2[슬픔]
        F --> F3[분노]
        F --> F4[기타 감정...]
        
        D --> G[개체명 인식]
        G --> G1[인물]
        G --> G2[장소]
        G --> G3[활동]
        G --> G4[기타 정보...]
        
        E --> H[상황 컨텍스트]
        H --> H1[시간 정보]
        H --> H2[사건 순서]
        H --> H3[인과 관계]
    end
    
    subgraph DB_저장
        F --> I[데이터 구조화]
        G --> I
        H --> I
        
        I --> J[(데이터베이스)]
        J --> K[감정 데이터 테이블]
        J --> L[컨텍스트 데이터 테이블]
        J --> M[관계 데이터 테이블]
    end
    
    style AI_분석 fill:#f9f,stroke:#333,stroke-width:2px
    style DB_저장 fill:#bbf,stroke:#333,stroke-width:2px\
    ```
    