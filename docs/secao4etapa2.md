## Modelagem inicial, diagrama de classes, diagramas de sequência, casos de uso, etc.

Na etapa 1, foi exposto o seguinte diagrama de case de uso para uma pessoa comum que visitaria a aplicação:

![diagrama de casos de uso](https://www.plantuml.com/plantuml/png/RP0nQWD134LxdK9ixoAsws1mRX2INing7S7ko4YQAkGm8KNka7OlbXb8y6Ac_NhlW_x9WopACiFCKs0ecbpU0aSnJY6Q0IY56ZvnBZa9vM20TgDycHc7P_7WXN3aXgm_ZV41tm6nE2VoofnDo6xd0SdnvVomHLxPP99KCG-AuZZMoZjXtnUChoLe_Lw_j5gErvc29hM5_4yyTCLRl-F44arLGorXwfKlwwU9_dSSuGDWCmBkTe_jYKwsxsI7JdQ44-UnRlyB)

Em que a última ação (criar denúncia) foi destrinchada em um diagrama de sequência. Agora, pensa-se em sequências para as duas primeiras ações, considerando que nem sempre o usuário queira realizar denúncias, podendo ter o objetivo de apenas ler o conteúdo gerado pelo uso de outras pessoas: 

![diagrama de sequência](https://www.plantuml.com/plantuml/png/fP2nIWD148RxVOef4p0la4A2-022O3_PsvY1lTbZPbR4jn4BAokniTqNSysHR09t8DWjDz__tpUpKKEnt4U7tfB00oaPiWKte1Xv6f0Dxaajz7ZnxGRP9-TE0LXT7pbOGqoFn8kikRmAfIlGm7jSkYEmgd1Bhi4dtf7qMDxBMu8kZFc6NzBXcROaa8QAVmMTStWYpHZf1IkQJL1hCPTlzeHwLZrkKlbjLezo6pWVaCNIZPDMkZvhW25l8tdipiicHLjeNZL5Gm5CG5m-FAN_hXw4TkHHGCAGhTrrY6YuIzBZt1yQeN3OpWIxUNCDCLHVHhax1HVBYVCsfmPEddXV7-LJo5TX_8CmyM4y7kHtHo_KrnTVXDqcS9Vx-0C0)

Para os moderadores da aplicação, foi exibido o seguinte diagrama para a etapa 1:

![diagrama de casos de uso](https://www.plantuml.com/plantuml/png/RS-nIeD13C3nFKyHkXUnxIoLkheeFa2uIpy3TnT9SfFuCEBWExZUY_afM4lRzPyV8Tbwa4Ml1Ghl0qFHP7eEp6ASGhG1K0erlDVCHbaDu6T2RIgCYqVnu4gO6U-uZQ-MX7o1hu3OdHFvR6uJkvFDvX-GuzFk-aH9a5qPftvHhuxr0tkOj4biRdsyc-YVMn-xdTRU9D7u71-AIIk-50hQgzN3uWsy0HpUm-NovlUsqx8wA-kpie4jjznh-GO0)

Não foram criados diagramas de sequência para ações dos moderadores, o que é feito agora:

![diagrama de sequência](https://www.plantuml.com/plantuml/png/TOz1JiCm44NtFiKi6ubUe0jK0LjMdE0JJyj8YISQZoMkKx7W16pOvc8OGZ6HsasasEzzFU-pmxoCGq3lQlIeaGrHBKmmbruc9ASdoSuZLcTtIBs6y2VGzlRCqOu6FKhQb5pcaudUKERqWYwSWMs5cxcZNjD1RCJyFhyfHLxyXgzfVfLdCTAfuX-ShpL4JlDdwWMP9axrpolR9fSNB5pvmUuHaTs-lvikBDTjSJLuO77yMxjSs8HhZKWO9CCUVXistQN2Ou5561ddCZYYKaHLvrDrEOImvnJBE7m1)

Pensa-se nas possibilidades de uso da aplicação por parte das plataformas, que seriam as redes sociais onde ocorreriam os possíveis crimes denunciados. Caso a plataforma seja um ator do processo, poderia ter um cadastro controlado por um representante, mas com limitações, pois as redes sociais seriam os atores com mais poder na dinâmica, e isso dependeria da intermediação dos moderadores entre o público geral e a plataforma, o que é dito no diagrama de caso de uso para o moderador. Nesse caso, abaixo está um possível diagrama de sequência, baseado no diagrama acima:

![diagrama de sequência](https://www.plantuml.com/plantuml/png/XP91Ri8m44NtFiKiGIeNO56XjjjAbNg28Px0I64SZSTIrTkWBdg2RhhDnJeGm4G2TGEn_TxF7pchRAXMTbt0nfB2Quga69E6tlUvuHx5u9spqGudUqyeJJfPRnqQjaaT2PS4M3oUHLX2bpOiivBBi5TE3v19jZWFPs3XS3MNq2HfsVE6x-4hGQJHh_YKfWzUiqBg7V-XVAz391b-fM7Cq9FuofojaUD88rUEs3D6pAQ7tzayZCSrSHBO4XjUfTriM8Mx7L6muupwSkemczzgk2ce4HMKSkdCKo2YgyFUNReMwisunN9yKiXfhLJBX4fDov0qk6FP7kgqb2TbflF5uxd_GN_9-dz4T-uCY5OS-ZpVFu9INwmkhzuImeea7ZxXFm00)

Na seção [Material de código](materialdecódigo2.md), encontra-se a explicação para a utilidade do diagrama de classes abaixo, com uso de interface:

![print4](https://github.com/user-attachments/assets/1683f478-9eab-48a2-b1f4-88526ad9b990)




